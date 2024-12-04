package com.microservice.user.application.dto;

import com.microservice.user.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponse {
    private String name;
    private String lastName;
    private int age;
    private long documentNumber;
    private String phone;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private RoleDto role;
}