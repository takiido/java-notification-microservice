package com.takiido.notificationhub.service;

import com.takiido.notificationhub.model.Notification;
import com.takiido.notificationhub.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        return repo.findById(id).orElseThrow(() -> new RuntimeException("No notification found with id:" + id));
    }

    @Transactional
    public Notification update(long id, Notification changes) {
        Notification n = findById(id);

        if (changes.getContent() != null) {
            n.setContent(changes.getContent());
        }

        if (changes.getRecipient() != null) {
            n.setRecipient(changes.getRecipient());
        }

        if (changes.getType() != null) {
            n.setType(changes.getType());
        }

        return repo.save(n);
    }

    public void remove(long id) {
        repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No notification found with id:" + id));
        repo.deleteById(id);
    }

    @Transactional
    public Notification markAsSent(long id) {
        Notification n = findById(id);
        LocalDateTime now = LocalDateTime.now();
        n.setLastSent(now.toString());
        n.setSent(true);

        // TODO: Implement actual notification send logic
        System.out.printf("Notification marked as sent id = %d, %s\n", id, now);

        return repo.save(n);
    }
}
