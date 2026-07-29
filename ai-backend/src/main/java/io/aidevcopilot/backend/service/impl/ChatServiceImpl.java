package io.aidevcopilot.backend.service.impl;

import io.aidevcopilot.backend.dto.TaskRequest;
import io.aidevcopilot.backend.dto.TaskResponse;
import io.aidevcopilot.backend.service.ChatService;
import io.aidevcopilot.core.model.PromptContext;
import io.aidevcopilot.core.task.TaskRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private static final Logger log =
            LoggerFactory.getLogger(ChatServiceImpl.class);

    private final TaskRouter taskRouter;

    public ChatServiceImpl(TaskRouter taskRouter) {
        this.taskRouter = taskRouter;
    }

    @Override
    public TaskResponse execute(TaskRequest request) {

        log.info("Processing AI task: {}", request.task());

        PromptContext context = new PromptContext(
                request.task(),
                request.input(),
                null
        );

        String response = taskRouter.execute(context);

        log.info("AI task processed successfully");

        return new TaskResponse(response);
    }
}