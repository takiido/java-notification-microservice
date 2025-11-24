package com.takiido.notificationhub.service;

import com.takiido.notificationhub.model.Notification;
import com.takiido.notificationhub.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public Notification create(Notification notification) {
        return repo.save(notification);
    }

    public List<Notification> findAll() {
        return repo.findAll();
    }

    public Notification findById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Notification update(long id, Notification notification) {
        Notification n = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        if (notification.getContent() != null) {
            n.setContent(notification.getContent());
        }

        if (notification.getRecipient() != null) {
            n.setRecipient(notification.getRecipient());
        }

        if (notification.getType() != null) {
            n.setType(notification.getType());
        }

        return repo.save(n);
    }

    public void remove(long id) {
        repo.deleteById(id);
    }
}
