package com.microservice.user.application.mapper;

import com.microservice.user.application.dto.RoleRequest;
import com.microservice.user.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleRequestMapper {
    Role toRole(RoleRequest roleRequest);
}