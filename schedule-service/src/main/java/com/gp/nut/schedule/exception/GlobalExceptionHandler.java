package com.gp.nut.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // 스프링에게 예외처리 핸들러임을 명시
public class GlobalExceptionHandler {

  // 유효성 검사 실패 시 처리 (DTO 검증 에러)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.put(error.getField(), error.getDefaultMessage());
    }

    return ResponseEntity.badRequest().body(errors);  // HTTP 400, 에러 메시지 리턴
  }

  // 기타 모든 예외 처리 (예시)
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleAllExceptions(Exception ex) {
    ex.printStackTrace();  // 로그 출력 (필요 시)
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("서버 에러가 발생했습니다: " + ex.getMessage());
  }
}
