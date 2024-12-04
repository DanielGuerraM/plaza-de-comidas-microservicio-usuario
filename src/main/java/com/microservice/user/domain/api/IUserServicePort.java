package com.microservice.user.domain.api;

import com.microservice.user.domain.model.User;
import com.microservice.user.infrastructure.exception.UserAlreadyExistsException;
import com.microservice.user.infrastructure.exception.UserNotFoundException;

public interface IUserServicePort {
    void saveUser(User user) throws UserAlreadyExistsException;
    User findUser(long id) throws UserNotFoundException;
}