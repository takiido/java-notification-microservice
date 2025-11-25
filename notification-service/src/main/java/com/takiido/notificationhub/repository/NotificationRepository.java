package com.takiido.notificationhub.repository;

import com.takiido.notificationhub.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAllByRecipient(String recipient);
}
