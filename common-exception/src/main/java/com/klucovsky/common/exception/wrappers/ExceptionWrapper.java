package com.klucovsky.common.exception.wrappers;

import java.util.Map;

public abstract class ExceptionWrapper {

     protected ExceptionWrapper next;

     public void setNextChain(final ExceptionWrapper next) {
          this.next = next;
     }

     public void next(final Throwable error, final Map<String, Object> errorAttributes) {
          if (next == null) {
               errorAttributes.put("exception", error.getClass().getSimpleName());
          } else {
               next.addErrorAttributes(error, errorAttributes);
          }
     }

     public abstract void addErrorAttributes(Throwable error, Map<String, Object> errorAttributes);
}
