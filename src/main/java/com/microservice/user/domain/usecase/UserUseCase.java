package com.microservice.user.domain.usecase;

import com.microservice.user.domain.api.IUserServicePort;
import com.microservice.user.domain.model.User;
import com.microservice.user.domain.spi.IUserPersistencePort;
import com.microservice.user.infrastructure.exception.UserAlreadyExistsException;
import com.microservice.user.infrastructure.exception.UserNotFoundException;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) throws UserAlreadyExistsException {
        userPersistencePort.saveUser(user);
    }

    @Override
    public User findUser(long id) throws UserNotFoundException {
        return userPersistencePort.findUser(id);
    }
}
