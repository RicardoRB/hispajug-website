package com.hispajug.services;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.serde.annotation.Serdeable;
import reactor.core.publisher.Mono;

@Client("${ollama.url}")
public interface OllamaClient {

    @Post("/api/generate")
    Mono<OllamaResponse> generate(@Body OllamaRequest request);

    @Serdeable
    record OllamaRequest(String model, String prompt, boolean stream) {}

    @Serdeable
    record OllamaResponse(String response, boolean done) {}
}
