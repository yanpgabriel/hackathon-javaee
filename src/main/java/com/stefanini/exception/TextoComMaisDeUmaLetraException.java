package com.stefanini.exception;

import javax.ws.rs.WebApplicationException;

public class TextoComMaisDeUmaLetraException extends WebApplicationException {
    public TextoComMaisDeUmaLetraException() {
        super();
      }
      public TextoComMaisDeUmaLetraException(String msg) {
        super(msg);
      }
      public TextoComMaisDeUmaLetraException(String msg, WebApplicationException e)  {
        super(msg, e);
      }
}
