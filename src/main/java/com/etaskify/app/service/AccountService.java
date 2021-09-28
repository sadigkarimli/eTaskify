package com.etaskify.app.service;

import com.etaskify.app.dto.SignUpRequest;
import com.etaskify.app.dto.UserResponse;

public interface AccountService {
    UserResponse createAccount(SignUpRequest signUpRequest);
}
