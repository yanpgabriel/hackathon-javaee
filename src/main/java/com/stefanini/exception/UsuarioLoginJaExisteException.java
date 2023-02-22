package com.stefanini.exception;

import javax.ws.rs.WebApplicationException;

public class UsuarioLoginJaExisteException extends WebApplicationException {
    public UsuarioLoginJaExisteException() {
        super();
      }
      public UsuarioLoginJaExisteException(String msg) {
        super(msg);
      }
      public UsuarioLoginJaExisteException(String msg, WebApplicationException e)  {
        super(msg, e);
      }
}
