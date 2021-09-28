package com.etaskify.app.controller;

import com.etaskify.app.dto.UserResponse;
import com.etaskify.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

//    private final UserService userService;

    @GetMapping("/me")
    public UserResponse getProfile() {
        return null;
    }


}
