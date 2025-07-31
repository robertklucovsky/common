package com.klucovsky.common.api.adapter.utilities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.klucovsky.common.api.adapter.utilities.Strings.isValid;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageableUtility {

    public static Pageable getPageable(final String page, final String size, final String sortList) {
        if (isValid(page) || isValid(sortList)) {
            int pageNum = Integer.parseInt(Optional.ofNullable(page).orElse("1")) - 1;
            if (pageNum < 0) pageNum = 0;
            int sizeNum = Integer.parseInt(Optional.ofNullable(size).orElse("100"));
            Sort sort = Sort.unsorted();
            if (isValid(sortList)) {
                List<Sort.Order> orders = Arrays.stream(sortList.split(","))
                        .map(order -> order.startsWith("!")
                                ? Sort.Order.desc(order.substring(1))
                                : Sort.Order.asc(order))
                        .toList();
                sort = Sort.by(orders);
            }
            return PageRequest.of(pageNum, sizeNum, sort);
        }
        return Pageable.unpaged();
    }

    public static long getSkip(final Pageable pageable) {
        final long take = pageable.isPaged() ? pageable.getPageSize() : 100;
        return take * (pageable.isPaged() ? pageable.getPageNumber() : 0);
    }

    public static long getTake(final Pageable pageable) {
        return pageable.isPaged() ? pageable.getPageSize() : 100;
    }
}
