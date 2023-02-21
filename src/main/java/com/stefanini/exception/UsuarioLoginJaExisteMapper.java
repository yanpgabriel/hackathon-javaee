package com.stefanini.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UsuarioLoginJaExisteMapper implements ExceptionMapper<UsuarioLoginJaExisteException> {

    @Override
    public Response toResponse(UsuarioLoginJaExisteException exception) {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build(); 
    }
    
}
