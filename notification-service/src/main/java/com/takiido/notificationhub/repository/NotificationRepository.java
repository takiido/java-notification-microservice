package com.takiido.notificationhub.repository;

import com.takiido.notificationhub.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
