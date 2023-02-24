package com.stefanini.exception;

import javax.ws.rs.WebApplicationException;

public class MesNaoExisteException extends WebApplicationException {
    public MesNaoExisteException() {
        super();
      }
      public MesNaoExisteException(String msg) {
        super(msg);
      }
      public MesNaoExisteException(String msg, WebApplicationException e)  {
        super(msg, e);
      }
}
