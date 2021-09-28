package com.etaskify.app.controller;

import com.etaskify.app.dto.SignUpRequest;
import com.etaskify.app.dto.UserSummaryResponse;
import com.etaskify.app.service.AccountService;
import com.etaskify.app.util.UriBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "Accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/signup")
    @Operation(description = "Sign up a user as a organization admin ", tags = {"Accounts"})
    public ResponseEntity<UserSummaryResponse> signUpAccount(
            @Valid @RequestBody SignUpRequest signUpRequest
    ) {
        log.info("User signing up...");

        UserSummaryResponse userResponse = accountService.createAccount(signUpRequest);
        URI created = UriBuilder.build("/users/me");

        return ResponseEntity.created(created).body(userResponse);
    }
}
