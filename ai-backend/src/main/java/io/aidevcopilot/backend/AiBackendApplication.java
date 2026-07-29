package io.aidevcopilot.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "io.aidevcopilot")
@EnableJpaRepositories(basePackages = "io.aidevcopilot")
@EntityScan(basePackages = "io.aidevcopilot")
public class AiBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiBackendApplication.class, args);
    }
}