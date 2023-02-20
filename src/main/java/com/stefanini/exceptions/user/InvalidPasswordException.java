package com.stefanini.exceptions.user;

import com.stefanini.exceptions.ErrorResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class InvalidPasswordException extends WebApplicationException {

    public InvalidPasswordException(){
        super(Response.status(400)
                .entity(
                        new ErrorResponse(
                        "A senha deve possuir pelo menos: " +
                                " 1 caractere especial, 1 caractere maíúsculo, 1 caractere minúsculo e 1 digito",
                        Response.Status.BAD_REQUEST.getStatusCode())
                )
                .build());
    }
}
