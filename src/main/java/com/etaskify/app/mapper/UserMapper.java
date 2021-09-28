package com.etaskify.app.mapper;

import com.etaskify.app.dto.SignUpRequest;
import com.etaskify.app.dto.UserResponse;
import com.etaskify.app.model.Role;
import com.etaskify.app.model.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(config = CentralConfig.class,
        uses = {OrganizationMapper.class, RoleMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "surname", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    User toUser(SignUpRequest signUpRequest);

    @Mapping(target = "organizationDetails", source = "organization")
    @Mapping(target = "roles", qualifiedByName = {"mapToRoleSet"})
    UserResponse toUserResponse(User user);
}
