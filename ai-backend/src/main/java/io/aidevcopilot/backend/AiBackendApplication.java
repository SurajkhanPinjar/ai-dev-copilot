package io.aidevcopilot.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.aidevcopilot")
public class AiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiBackendApplication.class, args);
    }
}