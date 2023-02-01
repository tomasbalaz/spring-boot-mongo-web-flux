package sk.balaz.springbootmongowebflux.notification;

public record CreateNotificationRequest(
        String id,
        String message
) { }
