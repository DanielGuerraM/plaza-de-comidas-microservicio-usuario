package com.microservice.user.infrastructure.exceptionhandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionResponse {
    USER_NOT_FOUND("An attempt has been made to find a user who is not registered", HttpStatus.NOT_FOUND.value(), "The user you are trying to find does not exist"),
    USER_ALREADY_REGISTERED("An attempt was made to register a user with a document number that is already registered", HttpStatus.CONFLICT.value(), "The document number is already registered"),
    ROLE_NOT_FOUND("An attempt has been made to register a user with a role that does not exist", HttpStatus.NOT_FOUND.value(), "The role you are trying to assign does not exist"),
    INVALID_AGE("An attempt has been made to register a user with an invalid age", HttpStatus.CONFLICT.value(), "The minimum age of the user must be 18 years old"),
    INVALID_EMAIL("An attempt was made to register a user with an invalid e-mail address", HttpStatus.CONFLICT.value(), "The email entered is invalid"),
    INVALID_PHONE("An attempt was made to register a user with a phone number that exceeded 13 characters", HttpStatus.CONFLICT.value(), "The phone number cannot exceed 13 characters in length");

    private String technicalMessage;
    private int code;
    private String message;

    ExceptionResponse(String technicalMessage, int code, String message) {
        this.technicalMessage = technicalMessage;
        this.code = code;
        this.message = message;
    }
}