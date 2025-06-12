package com.gp.nut.command.dto;

import com.gp.nut.command.entity.UserRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserCreateRequest {
    private final String username;
    private final String password;
    private final String name;
    private final UserRole role;
}
