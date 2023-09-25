package com.amigoscode.notification;

import com.amigoscode.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public void sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerEmail())
                .message(request.message())
                .sentAt(LocalDateTime.now())
                .build();
        repository.save(notification);
    }
}
