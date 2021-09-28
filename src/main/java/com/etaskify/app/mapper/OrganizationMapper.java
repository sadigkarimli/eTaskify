package com.etaskify.app.mapper;

import com.etaskify.app.dto.OrganizationSignUpDetails;
import com.etaskify.app.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = CentralConfig.class)
public interface OrganizationMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    Organization toOrganization(OrganizationSignUpDetails orgSignUpDetails);
}
