package com.microservice.user.infrastructure.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleNotFoundException extends Exception{
    public RoleNotFoundException() {
        super();
    }
}