package io.aidevcopilot.plugin.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.aidevcopilot.plugin.dto.SearchRequest;
import io.aidevcopilot.plugin.dto.SearchResponse;
import okhttp3.*;

import java.io.IOException;

public class AiBackendClient {

    private static final String URL =
            "http://localhost:8080/api/v1/ai/search";

    private final OkHttpClient client =
            new OkHttpClient.Builder()
                    .connectTimeout(java.time.Duration.ofSeconds(30))
                    .readTimeout(java.time.Duration.ofMinutes(2))
                    .writeTimeout(java.time.Duration.ofMinutes(2))
                    .build();

    private final ObjectMapper mapper = new ObjectMapper();

    public String ask(String question) throws IOException {

        SearchRequest request =
                new SearchRequest(question, 5);

        String json =
                mapper.writeValueAsString(request);

        RequestBody body =
                RequestBody.create(
                        json,
                        MediaType.get("application/json")
                );

        Request httpRequest =
                new Request.Builder()
                        .url(URL)
                        .post(body)
                        .build();

        System.out.println("URL: " + URL);
        System.out.println("Question: " + question);

        try (Response response =
                     client.newCall(httpRequest).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException(
                        "Backend returned " + response.code()
                );
            }

            SearchResponse searchResponse =
                    mapper.readValue(
                            response.body().string(),
                            SearchResponse.class
                    );

            return searchResponse.getData().getAnswer();
        }
    }
}