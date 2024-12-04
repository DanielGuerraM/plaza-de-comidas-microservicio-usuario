package com.microservice.user.infrastructure.out.jpa.repository;

import com.microservice.user.domain.model.Role;
import com.microservice.user.infrastructure.out.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Integer> {
    boolean existsByName(String name);
    Optional<RoleEntity> findByName(String name);
}
