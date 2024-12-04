package com.microservice.user.domain.api;

import com.microservice.user.domain.model.Role;
import com.microservice.user.infrastructure.exception.RoleNotFoundException;

import java.util.Optional;

public interface IRoleServicePort {
    Role findRole(Role role) throws RoleNotFoundException;
}