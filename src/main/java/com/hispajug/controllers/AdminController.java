package com.hispajug.controllers;

import com.hispajug.models.Lesson;
import com.hispajug.services.OllamaService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller("/api/admin/lessons")
public class AdminController {

    private final OllamaService ollamaService;

    public AdminController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @Post("/{id}/generate")
    public Mono<Lesson> generateLesson(UUID id) {
        // In a real app, we would fetch the lesson metadata by id first.
        // For this task, we'll simulate the generation process.
        return ollamaService.generateContent("Create a Java lesson for ID: " + id)
                .map(content -> new Lesson(id, "Generated Lesson", content));
    }
}
