package com.challenge.pricerest.infrastructure.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

   private static final String TIMESTAMP = "timestamp";
   private static final String MESSAGE = "message";
   private static final String STATUS = "status";
   private static final String ERROR = "error";

   @ExceptionHandler(PriceNotFoundException.class)
   public ResponseEntity<Map<String, Object>> handlePriceNotFoundException(PriceNotFoundException ex) {
      Map<String, Object> errorResponse = new HashMap<>();
      errorResponse.put(TIMESTAMP, LocalDateTime.now().toString());
      errorResponse.put(MESSAGE, ex.getMessage());
      errorResponse.put(STATUS, NOT_FOUND.value());
      errorResponse.put(ERROR, NOT_FOUND.getReasonPhrase());
      return ResponseEntity.status(NOT_FOUND)
            .body(errorResponse);
   }

}
