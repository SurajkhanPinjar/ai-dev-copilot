package io.aidevcopilot.backend.dto;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private boolean success;

    private LocalDateTime timestamp;

    private T data;

    public ApiResponse() {
    }

    public ApiResponse(boolean success,
                       LocalDateTime timestamp,
                       T data) {

        this.success = success;
        this.timestamp = timestamp;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(
                true,
                LocalDateTime.now(),
                data
        );
    }

    public static <T> ApiResponse<T> failure(T data) {
        return new ApiResponse<>(
                false,
                LocalDateTime.now(),
                data
        );
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}