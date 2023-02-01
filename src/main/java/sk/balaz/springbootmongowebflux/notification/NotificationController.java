package sk.balaz.springbootmongowebflux.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping()
    public Mono<Notification> createNotification(@RequestBody CreateNotificationRequest request) {
        return notificationService.createNotification(request);
    }
}
