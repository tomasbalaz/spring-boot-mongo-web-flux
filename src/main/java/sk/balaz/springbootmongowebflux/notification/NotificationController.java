package sk.balaz.springbootmongowebflux.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public Flux<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("{notificationId}")
    public Mono<Notification> getNotificationById(@PathVariable("notificationId") String notificationId) {
        return notificationService.getNotificationById(notificationId);
    }
}
