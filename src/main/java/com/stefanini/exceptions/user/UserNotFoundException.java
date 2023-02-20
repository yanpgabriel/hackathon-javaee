package com.stefanini.exceptions.user;

import com.stefanini.exceptions.ErrorResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class UserNotFoundException extends WebApplicationException {

    public UserNotFoundException(){
        super(Response.status(404)
                .entity(
                        new ErrorResponse(
                        "Usuário não encontrado",
                        Response.Status.NOT_FOUND.getStatusCode())
                )
                .build());
    }

}
