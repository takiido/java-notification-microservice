package com.takiido.notificationhub.service;

import com.takiido.notificationhub.model.Notification;
import com.takiido.notificationhub.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public Notification createNotification(Notification notification) {
        return repo.save(notification);
    }
}
