package com.hispajug.services;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

@Singleton
public class OllamaService {

    private static final Logger LOG = LoggerFactory.getLogger(OllamaService.class);
    private final OllamaClient ollamaClient;
    private final String model;

    public OllamaService(OllamaClient ollamaClient, @Value("${ollama.model:llama3}") String model) {
        this.ollamaClient = ollamaClient;
        this.model = model;
    }

    public Mono<String> generateContent(String prompt) {
        LOG.info("Generating content with prompt: {} using model: {}", prompt, model);
        return ollamaClient.generate(new OllamaClient.OllamaRequest(model, prompt, false))
                .map(OllamaClient.OllamaResponse::response)
                .onErrorResume(e -> {
                    LOG.error("Failed to connect to Ollama: {}", e.getMessage());
                    return Mono.error(new RuntimeException("AI Generation failed: " + e.getMessage(), e));
                });
    }
}
