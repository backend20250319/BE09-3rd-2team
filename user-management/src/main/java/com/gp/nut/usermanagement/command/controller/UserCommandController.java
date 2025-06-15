package com.gp.nut.usermanagement.command.controller;

import com.gp.nut.usermanagement.command.dto.UserCreateRequest;
import com.gp.nut.usermanagement.command.dto.UserRoleUpdateRequest;
import com.gp.nut.usermanagement.command.entity.User;
import com.gp.nut.usermanagement.command.service.UserCommandService;
import com.gp.nut.usermanagement.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserCommandController {

    private final UserCommandService userCommandService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(@RequestBody UserCreateRequest request) {
        userCommandService.registerUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(null));
    }

    @GetMapping("view/{userId}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long userId) {
        User user = userCommandService.getUserById(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(user));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<ApiResponse<Void>> updateUser(@PathVariable Long userId, @RequestBody UserCreateRequest request) {
        userCommandService.updateUser(userId, request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(null));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long userId) {
        userCommandService.deleteUser(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(null));
    }

    @PutMapping("{userId}/role")
    public ResponseEntity<ApiResponse<Void>> updateUserRole(@PathVariable Long userId, @RequestBody UserRoleUpdateRequest request) {
        userCommandService.updateUserRole(userId, request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(null));
    }

}
