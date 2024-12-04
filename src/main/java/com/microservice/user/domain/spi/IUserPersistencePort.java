package com.microservice.user.domain.spi;

import com.microservice.user.domain.model.User;
import com.microservice.user.infrastructure.exception.UserAlreadyExistsException;
import com.microservice.user.infrastructure.exception.UserNotFoundException;

public interface IUserPersistencePort {
    void saveUser(User user) throws UserAlreadyExistsException;
    User findUser(long id) throws UserNotFoundException;
}