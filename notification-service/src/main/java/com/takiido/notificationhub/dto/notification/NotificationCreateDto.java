package com.takiido.notificationhub.dto.notification;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NotificationCreateDto {
    @NotBlank(message = "content is required")
    private String content;
    
    @NotBlank(message = "recipient is required")
    private String recipient;

    @NotBlank(message = "type is required")
    private String type;
}
