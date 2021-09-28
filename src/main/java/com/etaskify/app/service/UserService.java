package com.etaskify.app.service;

import com.etaskify.app.dto.UserAddRequest;
import com.etaskify.app.dto.UserSummaryResponse;

public interface UserService {
    UserSummaryResponse createUser(UserAddRequest userAddRequest);
}
