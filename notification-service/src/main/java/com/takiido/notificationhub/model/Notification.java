package com.takiido.notificationhub.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String recipient;
    private String content;

    private boolean sent = false;
    private LocalDateTime sentAt;
}
