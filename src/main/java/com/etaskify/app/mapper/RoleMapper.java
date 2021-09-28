package com.etaskify.app.mapper;

import com.etaskify.app.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(config = CentralConfig.class)
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Named("mapToRoleSet")
    static Set<String> mapToRoleSet(Set<Role> roles) {
        return roles.stream().map(role -> role.getRoleName().name())
                .collect(Collectors.toSet());
    }
}
