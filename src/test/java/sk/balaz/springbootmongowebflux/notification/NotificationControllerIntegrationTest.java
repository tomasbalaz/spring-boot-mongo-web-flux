package sk.balaz.springbootmongowebflux.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import sk.balaz.springbootmongowebflux.AbstractIntegrationTest;

class NotificationControllerIntegrationTest extends AbstractIntegrationTest {

    private Notification notification;

    @BeforeEach
    void setUp() {
        notification = Notification.builder()
                .message("Test Notification Message")
                .build();
    }

    @Test
    void itShouldCreateNotification() {

        webTestClient
                .post()
                .uri("/api/v1/notifications")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(notification), Notification.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.message").isEqualTo("Test Notification Message");

    }
}