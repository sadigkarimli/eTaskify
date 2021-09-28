package com.etaskify.app.service;

import com.etaskify.app.dto.SignUpRequest;
import com.etaskify.app.dto.UserSummaryResponse;

public interface AccountService {
    UserSummaryResponse createAccount(SignUpRequest signUpRequest);
}
