package com.etaskify.app.service;

import com.etaskify.app.dto.UserAddRequest;
import com.etaskify.app.dto.UserSummaryResponse;

import java.util.Set;

public interface UserService {

    UserSummaryResponse addUser(UserAddRequest userAddRequest);
    Set<String> getUserEmails(Set<Long> userIds);
}
