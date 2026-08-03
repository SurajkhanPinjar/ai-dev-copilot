package io.aidevcopilot.backend.service;

import io.aidevcopilot.backend.request.SearchRequest;
import io.aidevcopilot.backend.response.SearchResponse;

public interface ChatFacade {

    SearchResponse search(SearchRequest request);

}