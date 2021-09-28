package com.etaskify.app.service.impl;

import com.etaskify.app.dto.SignUpRequest;
import com.etaskify.app.dto.UserSummaryResponse;
import com.etaskify.app.mapper.UserMapper;
import com.etaskify.app.model.User;
import com.etaskify.app.repository.RoleRepository;
import com.etaskify.app.repository.UserRepository;
import com.etaskify.app.service.AccountService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserSummaryResponse createAccount(SignUpRequest signUpRequest) {
        User user = userMapper.toUser(signUpRequest);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));

        return userMapper.toUserSummaryResponse(userRepository.save(user));
    }
}
