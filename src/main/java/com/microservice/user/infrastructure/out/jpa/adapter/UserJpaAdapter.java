package com.microservice.user.infrastructure.out.jpa.adapter;

import com.microservice.user.domain.model.User;
import com.microservice.user.domain.spi.IUserPersistencePort;
import com.microservice.user.infrastructure.exception.UserAlreadyExistsException;
import com.microservice.user.infrastructure.exception.UserNotFoundException;
import com.microservice.user.infrastructure.out.jpa.entity.UserEntity;
import com.microservice.user.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.microservice.user.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findByDocumentNumber(user.getDocumentNumber()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public User findUser(long id) throws UserNotFoundException {
        return userEntityMapper.toUser(
                userRepository.findById(id).orElseThrow(
                        UserNotFoundException::new
        )
        );
    }
}