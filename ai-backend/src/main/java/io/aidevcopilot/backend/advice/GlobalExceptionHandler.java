package io.aidevcopilot.backend.advice;

import io.aidevcopilot.backend.dto.ApiError;
import io.aidevcopilot.backend.dto.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles @Valid request body validation failures.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<ApiError>> handleValidationException(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getDefaultMessage())
                .orElse("Validation failed");

        log.warn("Validation failed: {}", message);

        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                message
        );

        ApiResponse<ApiError> response =
                new ApiResponse<>(
                        false,
                        LocalDateTime.now(),
                        apiError
                );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    /**
     * Handles validation failures on request params/path variables.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<ApiError>> handleConstraintViolation(
            ConstraintViolationException ex) {

        log.warn("Constraint violation: {}", ex.getMessage());

        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage()
        );

        ApiResponse<ApiError> response =
                new ApiResponse<>(
                        false,
                        LocalDateTime.now(),
                        apiError
                );

        return ResponseEntity
                .badRequest()
                .body(response);
    }

    /**
     * Handles invalid arguments.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<ApiError>> handleIllegalArgumentException(
            IllegalArgumentException ex) {

        log.warn("Illegal argument: {}", ex.getMessage());

        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage()
        );

        ApiResponse<ApiError> response =
                new ApiResponse<>(
                        false,
                        LocalDateTime.now(),
                        apiError
                );

        return ResponseEntity
                .badRequest()
                .body(response);
    }

    /**
     * Handles all unexpected exceptions.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<ApiError>> handleException(
            Exception ex) {

        log.error("Unexpected error", ex);

        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred."
        );

        ApiResponse<ApiError> response =
                new ApiResponse<>(
                        false,
                        LocalDateTime.now(),
                        apiError
                );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}