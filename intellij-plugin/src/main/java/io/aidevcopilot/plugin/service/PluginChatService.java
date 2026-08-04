package io.aidevcopilot.plugin.service;

import io.aidevcopilot.plugin.client.AiBackendClient;

public class PluginChatService {

    private final AiBackendClient backendClient =
            new AiBackendClient();

    public String ask(String question) throws Exception {

        return backendClient.ask(question);
    }

    public String executeTask(
            String task,
            String input
    ) throws Exception {

        return backendClient.executeTask(
                task,
                input
        );
    }
}