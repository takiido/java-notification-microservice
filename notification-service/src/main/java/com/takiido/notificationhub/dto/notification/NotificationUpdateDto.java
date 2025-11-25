package com.takiido.notificationhub.dto.notification;

import lombok.Data;

@Data
public class NotificationUpdateDto {
    private String content;
    private String recipient;
    private String type;
}
