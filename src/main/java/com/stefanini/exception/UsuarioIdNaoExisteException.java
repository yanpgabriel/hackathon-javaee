package com.stefanini.exception;

import javax.ws.rs.WebApplicationException;

public class UsuarioIdNaoExisteException extends WebApplicationException {
    public UsuarioIdNaoExisteException() {
        super();
      }
      public UsuarioIdNaoExisteException(String msg) {
        super(msg);
      }
      public UsuarioIdNaoExisteException(String msg, WebApplicationException e)  {
        super(msg, e);
      }
}
