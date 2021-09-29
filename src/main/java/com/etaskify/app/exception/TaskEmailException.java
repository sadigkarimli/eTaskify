package com.etaskify.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TaskEmailException extends RuntimeException{

    public TaskEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
