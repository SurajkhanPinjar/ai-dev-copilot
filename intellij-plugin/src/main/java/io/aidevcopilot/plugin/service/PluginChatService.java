package io.aidevcopilot.plugin.service;

import io.aidevcopilot.plugin.client.AiBackendClient;

public class PluginChatService {

    private final AiBackendClient backendClient;

    public PluginChatService() {
        this.backendClient = new AiBackendClient();
    }

    /**
     * Ask a question using the RAG Search API.
     */
    public String ask(String question) throws Exception {

        return backendClient.ask(question);
    }

}