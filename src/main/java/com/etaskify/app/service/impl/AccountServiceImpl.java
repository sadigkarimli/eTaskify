package com.etaskify.app.service.impl;

import com.etaskify.app.dto.SignUpRequest;
import com.etaskify.app.dto.UserResponse;
import com.etaskify.app.mapper.UserMapper;
import com.etaskify.app.model.Role;
import com.etaskify.app.model.RoleName;
import com.etaskify.app.model.User;
import com.etaskify.app.repository.UserRepository;
import com.etaskify.app.service.AccountService;
import com.etaskify.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public UserResponse createAccount(SignUpRequest signUpRequest) {
        User user = userMapper.toUser(signUpRequest);

        Set<Role> roles = new HashSet<>();
        roles.add(Role.fromName(RoleName.USER));
        roles.add(Role.fromName(RoleName.ADMIN));

        user.setRoles(roles);
        User savedUser = userRepository.save(user);

        return userMapper.toUserResponse(savedUser);
    }
}
