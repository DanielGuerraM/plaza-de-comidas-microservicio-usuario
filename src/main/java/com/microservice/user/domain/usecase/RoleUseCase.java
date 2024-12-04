package com.microservice.user.domain.usecase;

import com.microservice.user.domain.api.IRoleServicePort;
import com.microservice.user.domain.model.Role;
import com.microservice.user.domain.spi.IRolePersistencePort;
import com.microservice.user.infrastructure.exception.RoleNotFoundException;

import java.util.Optional;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public Role findRole(Role role) throws RoleNotFoundException {
        return rolePersistencePort.findRole(role);
    }
}
