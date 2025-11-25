package com.takiido.notificationhub.mapper;

import com.takiido.notificationhub.dto.notification.NotificationCreateDto;
import com.takiido.notificationhub.dto.notification.NotificationDto;
import com.takiido.notificationhub.dto.notification.NotificationUpdateDto;
import com.takiido.notificationhub.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NotificationMapper {
    NotificationDto toDto(Notification notification);

    Notification fromDto(NotificationCreateDto dto);

    void updateNotificationFromDto(NotificationUpdateDto dto, @MappingTarget Notification notification);
}
