package com.microservice.user.infrastructure.exceptionhandler;

import com.microservice.user.domain.exception.InvalidAgeException;
import com.microservice.user.domain.exception.InvalidEmailException;
import com.microservice.user.domain.exception.InvalidPhoneException;
import com.microservice.user.infrastructure.exception.ExceptionDetail;
import com.microservice.user.infrastructure.exception.RoleNotFoundException;
import com.microservice.user.infrastructure.exception.UserAlreadyExistsException;
import com.microservice.user.infrastructure.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerAdvisor.class.getName());

    //404 - Not Found
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ExceptionDetail> handleRoleNotFoundException(RoleNotFoundException e) {
        LOG.error(ExceptionResponse.ROLE_NOT_FOUND.getTechnicalMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionDetail(ExceptionResponse.ROLE_NOT_FOUND.getCode(),
                        ExceptionResponse.ROLE_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDetail> handleUserNotFoundException(UserNotFoundException e) {
        LOG.error(ExceptionResponse.USER_NOT_FOUND.getTechnicalMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionDetail(ExceptionResponse.USER_NOT_FOUND.getCode(),
                        ExceptionResponse.USER_NOT_FOUND.getMessage()));
    }

    //405 - Conflict
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionDetail> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        LOG.error(ExceptionResponse.USER_ALREADY_REGISTERED.getTechnicalMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionDetail(ExceptionResponse.USER_ALREADY_REGISTERED.getCode(),
                        ExceptionResponse.USER_ALREADY_REGISTERED.getMessage()));
    }

    @ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<ExceptionDetail> handleInvalidAgeException(InvalidAgeException e) {
        LOG.error(ExceptionResponse.INVALID_AGE.getTechnicalMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionDetail(ExceptionResponse.INVALID_AGE.getCode(),
                        ExceptionResponse.INVALID_AGE.getMessage()));
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ExceptionDetail> handleInvalidEmailException(InvalidEmailException e) {
        LOG.error(ExceptionResponse.INVALID_EMAIL.getTechnicalMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionDetail(ExceptionResponse.INVALID_EMAIL.getCode(),
                        ExceptionResponse.INVALID_EMAIL.getMessage()));
    }

    @ExceptionHandler(InvalidPhoneException.class)
    public ResponseEntity<ExceptionDetail> handleInvalidPhoneException(InvalidPhoneException e) {
        LOG.error(ExceptionResponse.INVALID_PHONE.getTechnicalMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionDetail(ExceptionResponse.INVALID_PHONE.getCode(),
                        ExceptionResponse.INVALID_PHONE.getMessage()));
    }
}