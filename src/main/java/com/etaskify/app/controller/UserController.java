package com.etaskify.app.controller;

import com.etaskify.app.dto.UserAddRequest;
import com.etaskify.app.dto.UserSummaryResponse;
import com.etaskify.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Log
@RequiredArgsConstructor
@RestController
@Tag(name = "Users")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get current user profile details", tags = {"Users"})
    @GetMapping("/me")
    public UserSummaryResponse getProfile() {
        return null;
    }

    @Operation(summary = "Add a user to the organization", tags = {"Users"})
    @PostMapping("/")
    public ResponseEntity<UserSummaryResponse> createUser(
            @Valid @RequestBody UserAddRequest userAddRequest
    ) {
        return null;
    }

}
