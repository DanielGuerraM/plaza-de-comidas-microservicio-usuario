package com.microservice.user.infrastructure.out.jpa.mapper;

import com.microservice.user.domain.model.User;
import com.microservice.user.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    @Mapping(source = "roleId", target = "role")
    UserEntity toEntity(User user);
    @Mapping(source = "role", target = "role")
    User toUser(UserEntity userEntity);
}