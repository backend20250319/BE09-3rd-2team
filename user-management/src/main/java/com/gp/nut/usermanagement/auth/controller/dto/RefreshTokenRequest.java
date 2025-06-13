package com.gp.nut.usermanagement.auth.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefreshTokenRequest {
    private final String refreshToken;
}
