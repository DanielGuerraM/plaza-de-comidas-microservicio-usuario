package com.microservice.user.infrastructure.configuration;

import com.microservice.user.domain.model.Role;
import com.microservice.user.infrastructure.out.jpa.entity.RoleEntity;
import com.microservice.user.infrastructure.out.jpa.entity.UserEntity;
import com.microservice.user.infrastructure.out.jpa.repository.IRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private final IRoleRepository roleRepository;

    public DatabaseInitializer(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = Arrays.asList(
                new Role("ADMIN"),
                new Role("OWNER"),
                new Role("EMPLOYEE"),
                new Role("CLIENT")
        );

        for (Role role : roles) {
            if (!roleRepository.existsByName(role.getName())) {
                roleRepository.save(new RoleEntity(role.getName()));
            }
        }
    }
}