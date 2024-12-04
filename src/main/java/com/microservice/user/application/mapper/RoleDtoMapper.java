package com.microservice.user.application.mapper;

import com.microservice.user.application.dto.RoleDto;
import com.microservice.user.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleDtoMapper {

    @Mapping(source = "name", target = "value")
    RoleDto toDto(Role role);
}