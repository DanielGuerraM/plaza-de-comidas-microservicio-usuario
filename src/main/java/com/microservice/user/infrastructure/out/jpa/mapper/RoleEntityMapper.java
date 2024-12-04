package com.microservice.user.infrastructure.out.jpa.mapper;

import com.microservice.user.domain.model.Role;
import com.microservice.user.infrastructure.out.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper {
    RoleEntity toEntity(Role role);
    Role toRole(RoleEntity roleEntity);
}