package com.gp.nut.usermanagement.auth.controller;

import com.gp.nut.usermanagement.auth.dto.LoginRequest;
import com.gp.nut.usermanagement.auth.dto.RefreshTokenRequest;
import com.gp.nut.usermanagement.auth.dto.TokenResponse;
import com.gp.nut.usermanagement.auth.service.AuthService;
import com.gp.nut.usermanagement.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody LoginRequest request) {
        System.out.println("AuthController.login() called with username: " + request.getUsername());
        try {
            TokenResponse token = authService.login(request);
            System.out.println("Login successful, token generated");
            return ResponseEntity.ok(ApiResponse.success(token));
        } catch (Exception e) {
            System.out.println("Login failed with error: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

}
