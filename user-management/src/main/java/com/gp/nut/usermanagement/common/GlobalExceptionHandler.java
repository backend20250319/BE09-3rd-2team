package com.gp.nut.usermanagement.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ApiResponse<Void>> handleUserException(UserException e) {
        Errorcode errorcode = e.getErrorcode();
        return ResponseEntity.status(errorcode.getHttpStatus())
                .body(ApiResponse.fail(errorcode.getMessage(), errorcode.getCode()));
    }
}