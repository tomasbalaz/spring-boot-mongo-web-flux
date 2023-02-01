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

    public Mono<Notification> createNotification(CreateNotificationRequest request) {

        Notification notification = Notification.builder()
                .id(request.id())
                .message(request.message())
                .build();

        return notificationRepository.save(notification);
    }
}
