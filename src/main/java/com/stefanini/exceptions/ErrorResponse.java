package com.stefanini.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private String message;
    private Integer status;
    private List<String> errors;

    public ErrorResponse(String message, Integer status, List<String> errors) {
        this.message = message;
        this.status = status;
        this.errors = errors;
    }

    public ErrorResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getErrors(){
        return errors;
    }

    public void setErrors(List<String> errors){
        this.errors = errors;
    }
}
