package io.aidevcopilot.backend.service.impl;

import io.aidevcopilot.backend.request.SearchRequest;
import io.aidevcopilot.backend.response.SearchResponse;
import io.aidevcopilot.backend.service.ChatFacade;
import io.aidevcopilot.backend.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatFacadeImpl implements ChatFacade {

    private final ChatService chatService;

    @Override
    public SearchResponse search(SearchRequest request) {
        return chatService.search(request);
    }
}