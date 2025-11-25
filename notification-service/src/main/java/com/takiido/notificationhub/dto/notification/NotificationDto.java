package com.takiido.notificationhub.dto.notification;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDto {
    private long id;
    private String content;
    private String recipient;
    private String type;
    private LocalDateTime sentAt;
    private boolean sent;
}

