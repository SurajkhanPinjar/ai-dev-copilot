package io.aidevcopilot.backend.controller;

import io.aidevcopilot.backend.dto.ApiResponse;
import io.aidevcopilot.backend.dto.TaskRequest;
import io.aidevcopilot.backend.dto.TaskResponse;
import io.aidevcopilot.backend.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ai")
@Tag(
        name = "AI Tasks",
        description = "Endpoints for executing AI tasks"
)
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/tasks")
    @Operation(
            summary = "Execute AI Task",
            description = "Executes the requested AI task."
    )
    public ResponseEntity<ApiResponse<TaskResponse>> executeTask(
            @Valid @RequestBody TaskRequest request) {

        log.info("Received AI task: {}", request.task());

        long startTime = System.currentTimeMillis();

        TaskResponse response = chatService.execute(request);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info(
                "AI task '{}' completed in {} ms",
                request.task(),
                executionTime
        );

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        LocalDateTime.now(),
                        response
                )
        );
    }
}