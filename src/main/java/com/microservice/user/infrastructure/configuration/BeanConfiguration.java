package com.microservice.user.infrastructure.configuration;

import com.microservice.user.domain.api.IRoleServicePort;
import com.microservice.user.domain.api.IUserServicePort;
import com.microservice.user.domain.spi.IRolePersistencePort;
import com.microservice.user.domain.spi.IUserPersistencePort;
import com.microservice.user.domain.usecase.RoleUseCase;
import com.microservice.user.domain.usecase.UserUseCase;
import com.microservice.user.infrastructure.out.jpa.adapter.RoleJpaAdapter;
import com.microservice.user.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.microservice.user.infrastructure.out.jpa.mapper.RoleEntityMapper;
import com.microservice.user.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.microservice.user.infrastructure.out.jpa.repository.IRoleRepository;
import com.microservice.user.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleJpaAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }
}