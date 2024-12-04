package com.microservice.user.domain.spi;

import com.microservice.user.domain.model.Role;
import com.microservice.user.infrastructure.exception.RoleNotFoundException;

import java.util.Optional;

public interface IRolePersistencePort {
    Role findRole(Role role) throws RoleNotFoundException;
}