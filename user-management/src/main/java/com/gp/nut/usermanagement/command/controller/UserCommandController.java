package com.gp.nut.usermanagement.command.controller;

import com.gp.nut.usermanagement.command.dto.UserCreateRequest;
import com.gp.nut.usermanagement.command.service.UserCommandService;
import com.gp.nut.usermanagement.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserCommandController {

    private final UserCommandService userCommandService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(@RequestBody UserCreateRequest request) {
        userCommandService.registerUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(null));
    }

}
