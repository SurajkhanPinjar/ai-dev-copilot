package io.aidevcopilot.backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI aiDevCopilotOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("AI Dev Copilot API")
                                .version("1.0.0")
                                .description("""
                                        AI-powered Backend Engineering Assistant.

                                        Features:
                                        • AI Chat
                                        • Code Review
                                        • Repository Analysis
                                        • RAG-based PDF Q&A
                                        • Production Log Analysis
                                        """)
                                .contact(
                                        new Contact()
                                                .name("Suraj")
                                                .email("your-email@example.com")
                                )
                                .license(
                                        new License()
                                                .name("MIT License")
                                )
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Project Documentation")
                                .url("https://github.com/your-username/ai-dev-copilot")
                );
    }
}