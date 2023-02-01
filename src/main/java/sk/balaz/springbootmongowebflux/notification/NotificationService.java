package sk.balaz.springbootmongowebflux.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Flux<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Mono<Notification> getNotificationById(String id) {
        return notificationRepository.findById(id);
    }
}
