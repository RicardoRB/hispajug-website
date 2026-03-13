package com.hispajug;

import com.hispajug.models.Lesson;
import com.hispajug.services.OllamaClient;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@MicronautTest
class AdminControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    OllamaClient ollamaClient;

    @MockBean(OllamaClient.class)
    OllamaClient ollamaClient() {
        return mock(OllamaClient.class);
    }

    @Test
    void testGenerateLessonConnectionError() {
        UUID lessonId = UUID.randomUUID();
        when(ollamaClient.generate(any())).thenReturn(Mono.error(new RuntimeException("Connection refused")));

        HttpRequest<?> request = HttpRequest.POST("/api/admin/lessons/" + lessonId + "/generate", "");

        HttpClientResponseException exception = assertThrows(HttpClientResponseException.class, () -> {
            client.toBlocking().exchange(request, Lesson.class);
        });

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
        String body = exception.getResponse().getBody(String.class).orElse("");
        assertTrue(body.contains("AI Generation failed"));
    }

    @Test
    void testGenerateLessonSuccess() {
        UUID lessonId = UUID.randomUUID();
        when(ollamaClient.generate(any())).thenReturn(Mono.just(new OllamaClient.OllamaResponse("Mocked AI Content", true)));

        HttpRequest<?> request = HttpRequest.POST("/api/admin/lessons/" + lessonId + "/generate", "");
        HttpResponse<Lesson> response = client.toBlocking().exchange(request, Lesson.class);

        assertEquals(HttpStatus.OK, response.status());
        Lesson lesson = response.body();
        assertNotNull(lesson);
        assertEquals(lessonId, lesson.id());
        assertEquals("Mocked AI Content", lesson.content());
    }
}
