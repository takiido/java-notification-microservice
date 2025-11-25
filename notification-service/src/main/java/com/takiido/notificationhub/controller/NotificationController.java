package com.takiido.notificationhub.controller;


import com.takiido.notificationhub.dto.notification.NotificationCreateDto;
import com.takiido.notificationhub.dto.notification.NotificationDto;
import com.takiido.notificationhub.dto.notification.NotificationUpdateDto;
import com.takiido.notificationhub.mapper.NotificationMapper;
import com.takiido.notificationhub.model.Notification;
import com.takiido.notificationhub.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService service;
    private final NotificationMapper mapper;

    public NotificationController(NotificationService service,  NotificationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public Notification createNotification(@Valid @RequestBody NotificationCreateDto dto) {
        return service.create(mapper.fromDto(dto));
    }

    @GetMapping
    public ResponseEntity<List<NotificationDto>> findAll() {
        List<NotificationDto> body = service.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();

        return ResponseEntity.ok(body);
    }

    @GetMapping("/{id}")
    public NotificationDto findById(@PathVariable long id) {
        return mapper.toDto(service.findById(id));
    }

    @GetMapping("/recipient")
    public List<NotificationDto> findByRecipient(@RequestParam String recipient) {
        return service.findAllByRecipient(recipient)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @PutMapping("/{id}")
    public NotificationDto updateNotification(@PathVariable long id, @Valid @RequestBody NotificationUpdateDto dto) {
        Notification existing = service.findById(id);
        mapper.updateNotificationFromDto(dto, existing);
        return mapper.toDto(service.update(id, existing));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.remove(id);
    }

    @PatchMapping("/{id}/send")
    public ResponseEntity<Notification> send(@PathVariable long id) {
        Notification updated = service.markAsSent(id);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }
}
