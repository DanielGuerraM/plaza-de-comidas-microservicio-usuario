package com.microservice.user.application.handler;

import com.microservice.user.application.dto.UserRequest;
import com.microservice.user.application.dto.UserResponse;
import com.microservice.user.application.mapper.IUserResponseMapper;
import com.microservice.user.application.mapper.RoleDtoMapper;
import com.microservice.user.application.mapper.UserRequestMapper;
import com.microservice.user.domain.api.IRoleServicePort;
import com.microservice.user.domain.api.IUserServicePort;
import com.microservice.user.domain.exception.InvalidAgeException;
import com.microservice.user.domain.exception.InvalidEmailException;
import com.microservice.user.domain.exception.InvalidPhoneException;
import com.microservice.user.domain.model.Role;
import com.microservice.user.domain.model.User;
import com.microservice.user.infrastructure.exception.RoleNotFoundException;
import com.microservice.user.infrastructure.exception.UserAlreadyExistsException;
import com.microservice.user.infrastructure.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;
    private final IRoleServicePort roleServicePort;
    private final RoleDtoMapper roleDtoMapper;

    @Override
    public void saveUser(UserRequest userRequest) throws UserAlreadyExistsException, RoleNotFoundException, InvalidAgeException, InvalidEmailException, InvalidPhoneException {
        Role existingRole = roleServicePort.findRole(userRequest.getRole());
        User newUser = userRequestMapper.toUser(userRequest);

        if(!newUser.validateAge(newUser.getAge())) {
            throw new InvalidAgeException();
        }

        if(!newUser.validateEmail(newUser.getEmail())) {
            throw new InvalidEmailException();
        }

        if(!newUser.validatePhone(newUser.getPhone())) {
            throw new InvalidPhoneException();
        }

        newUser.setRoleId(existingRole);

        userServicePort.saveUser(newUser);
    }

    @Override
    public UserResponse findUser(long id) throws UserNotFoundException, RoleNotFoundException {
        User user = userServicePort.findUser(id);
        Role role = roleServicePort.findRole(user.getRoleId());
        return userResponseMapper.toResponse(user, roleDtoMapper.toDto(role));
    }
}