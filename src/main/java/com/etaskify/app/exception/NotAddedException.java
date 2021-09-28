package com.etaskify.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NotAddedException extends RuntimeException {
    public NotAddedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
