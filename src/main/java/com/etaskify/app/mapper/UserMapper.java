package com.etaskify.app.mapper;

import com.etaskify.app.dto.SignUpRequest;
import com.etaskify.app.dto.UserAddRequest;
import com.etaskify.app.dto.UserResponse;
import com.etaskify.app.dto.UserSummaryResponse;
import com.etaskify.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

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
    UserSummaryResponse toUserSummaryResponse(User user);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", source = "defaultPassword")
    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toUser(UserAddRequest userAddRequest);
}
