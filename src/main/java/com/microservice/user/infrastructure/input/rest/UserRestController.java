package com.microservice.user.infrastructure.input.rest;

import com.microservice.user.application.dto.UserRequest;
import com.microservice.user.application.dto.UserResponse;
import com.microservice.user.application.handler.IUserHandler;
import com.microservice.user.domain.exception.InvalidAgeException;
import com.microservice.user.domain.exception.InvalidEmailException;
import com.microservice.user.domain.exception.InvalidPhoneException;
import com.microservice.user.domain.model.User;
import com.microservice.user.infrastructure.exception.RoleNotFoundException;
import com.microservice.user.infrastructure.exception.UserAlreadyExistsException;
import com.microservice.user.infrastructure.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("microservice/v1/user")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserHandler userHandler;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody UserRequest userRequest) throws UserAlreadyExistsException, RoleNotFoundException, InvalidAgeException, InvalidEmailException, InvalidPhoneException {
        userHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "{idUser}")
    public ResponseEntity<UserResponse> findUser(@PathVariable long idUser) throws UserNotFoundException, RoleNotFoundException {
        return ResponseEntity.ok(userHandler.findUser(idUser));
    }
}