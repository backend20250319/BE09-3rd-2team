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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody LoginRequest request) {
        TokenResponse token = authService.login(request); // AuthService.login(request)에서 사용자 인증 후 JWT 생성
        return ResponseEntity.ok(ApiResponse.success(token)); // ApiResponse.success(token)을 통해 응답을 표준화
        // ResponseEntity.op(...)를 사용해 HTTP상태코드와 함꼐 응답 반환
    }

}
