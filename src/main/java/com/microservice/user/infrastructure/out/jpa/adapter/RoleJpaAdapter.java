package com.microservice.user.infrastructure.out.jpa.adapter;

import com.microservice.user.domain.model.Role;
import com.microservice.user.domain.spi.IRolePersistencePort;
import com.microservice.user.infrastructure.exception.RoleNotFoundException;
import com.microservice.user.infrastructure.out.jpa.mapper.RoleEntityMapper;
import com.microservice.user.infrastructure.out.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {
    private final IRoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Role findRole(Role role) throws RoleNotFoundException {
        return roleEntityMapper.toRole(roleRepository.findByName(role.getName()).orElseThrow(
                RoleNotFoundException::new
        ));
    }
}