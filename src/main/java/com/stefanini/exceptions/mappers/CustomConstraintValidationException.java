package com.stefanini.exceptions.mappers;

import com.stefanini.exceptions.ErrorResponse;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Provider
public class CustomConstraintValidationException implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
                .entity(new ErrorResponse(
                        "BAD REQUEST 400",
                        Response.Status.BAD_REQUEST.getStatusCode(),
                        e.getConstraintViolations().stream().map(c -> c.getMessage()).collect(Collectors.toList())
                ))
                .build();
    }
}
