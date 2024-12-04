package com.microservice.user.infrastructure.exception;

import com.microservice.user.infrastructure.exceptionhandler.ExceptionResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super();
    }
}