package com.hispajug.models;

import io.micronaut.serde.annotation.Serdeable;
import java.util.UUID;

@Serdeable
public record Lesson(UUID id, String title, String content) {
}
