package io.aidevcopilot.backend.service;

import io.aidevcopilot.backend.dto.TaskRequest;
import io.aidevcopilot.backend.dto.TaskResponse;

public interface ChatService {

    TaskResponse execute(TaskRequest request);

}