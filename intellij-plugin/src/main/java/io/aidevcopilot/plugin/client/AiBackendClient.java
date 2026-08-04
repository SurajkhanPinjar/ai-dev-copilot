package io.aidevcopilot.plugin.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.aidevcopilot.plugin.dto.SearchRequest;
import io.aidevcopilot.plugin.dto.SearchResponse;
import io.aidevcopilot.plugin.dto.TaskRequest;
import io.aidevcopilot.plugin.dto.TaskResponse;
import okhttp3.*;

import java.io.IOException;
import java.time.Duration;

public class AiBackendClient {

    private static final String BASE_URL =
            "http://localhost:8080";

    private static final MediaType JSON =
            MediaType.get("application/json");

    private final OkHttpClient client =
            new OkHttpClient.Builder()
                    .connectTimeout(Duration.ofSeconds(30))
                    .readTimeout(Duration.ofMinutes(2))
                    .writeTimeout(Duration.ofMinutes(2))
                    .build();

    private final ObjectMapper objectMapper =
            new ObjectMapper();

    /**
     * Calls the RAG Search API.
     */
    public String ask(String question) throws IOException {

        SearchRequest request =
                new SearchRequest(question, 5);

        String json =
                objectMapper.writeValueAsString(request);

        RequestBody body =
                RequestBody.create(json, JSON);

        Request httpRequest =
                new Request.Builder()
                        .url(BASE_URL + "/api/v1/ai/search")
                        .post(body)
                        .build();

        try (Response response =
                     client.newCall(httpRequest).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException(
                        "Backend returned " + response.code()
                );
            }

            SearchResponse result =
                    objectMapper.readValue(
                            response.body().string(),
                            SearchResponse.class
                    );

            return result.getData().getAnswer();
        }
    }

    /**
     * Calls the generic AI Task API.
     */
    public String executeTask(
            String task,
            String input
    ) throws IOException {

        TaskRequest request =
                new TaskRequest(
                        task,
                        input
                );

        String json =
                objectMapper.writeValueAsString(request);

        RequestBody body =
                RequestBody.create(json, JSON);

        Request httpRequest =
                new Request.Builder()
                        .url(BASE_URL + "/api/v1/ai/tasks")
                        .post(body)
                        .build();

        try (Response response =
                     client.newCall(httpRequest).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException(
                        "Backend returned " + response.code()
                );
            }

            TaskResponse result =
                    objectMapper.readValue(
                            response.body().string(),
                            TaskResponse.class
                    );

            return result.getData().getResponse();
        }
    }
}