package com.microservice.user.application.handler;

import com.microservice.user.application.dto.UserRequest;
import com.microservice.user.application.dto.UserResponse;
import com.microservice.user.domain.exception.InvalidAgeException;
import com.microservice.user.domain.exception.InvalidEmailException;
import com.microservice.user.domain.exception.InvalidPhoneException;
import com.microservice.user.domain.model.User;
import com.microservice.user.infrastructure.exception.RoleNotFoundException;
import com.microservice.user.infrastructure.exception.UserAlreadyExistsException;
import com.microservice.user.infrastructure.exception.UserNotFoundException;

public interface IUserHandler {
    void saveUser(UserRequest userRequest) throws UserAlreadyExistsException, RoleNotFoundException, InvalidAgeException, InvalidEmailException, InvalidPhoneException;
    UserResponse findUser(long id) throws UserNotFoundException, RoleNotFoundException;
}