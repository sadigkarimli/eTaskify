package com.etaskify.app.service.impl;

import com.etaskify.app.model.User;
import com.etaskify.app.repository.UserRepository;
import com.etaskify.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


}
