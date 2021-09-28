package com.etaskify.app.controller;

import com.etaskify.app.dto.SignUpRequest;
import com.etaskify.app.dto.UserResponse;
import com.etaskify.app.service.AccountService;
import com.etaskify.app.util.UriBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signUpAccount(
            @Valid @RequestBody SignUpRequest signUpRequest) {

        UserResponse userResponse = accountService.createAccount(signUpRequest);

        URI created = UriBuilder.build("/users/me");
        return ResponseEntity.created(created).body(userResponse);
    }
}
