package com.microservice.user.application.mapper;

import com.microservice.user.application.dto.RoleDto;
import com.microservice.user.application.dto.UserResponse;
import com.microservice.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {RoleDtoMapper.class})
public interface IUserResponseMapper {
    RoleDtoMapper INSTANCE = Mappers.getMapper(RoleDtoMapper.class);

    @Mapping(target = "role.value", source = "roleDto.value")
    UserResponse toResponse(User user, RoleDto roleDto);
}