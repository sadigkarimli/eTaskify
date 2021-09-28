package com.etaskify.app.service.impl;

import com.etaskify.app.dto.UserAddRequest;
import com.etaskify.app.dto.UserSummaryResponse;
import com.etaskify.app.mapper.UserMapper;
import com.etaskify.app.model.Role;
import com.etaskify.app.model.RoleName;
import com.etaskify.app.model.User;
import com.etaskify.app.repository.RoleRepository;
import com.etaskify.app.repository.UserRepository;
import com.etaskify.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public UserSummaryResponse addUser(UserAddRequest userAddRequest) {
        User user = userMapper.toUser(userAddRequest);

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getRoleByRoleName(RoleName.USER));

        user.setRoles(roles);
        return null;
    }
}
