package com.takiido.notificationhub.controller;


import com.takiido.notificationhub.model.Notification;
import com.takiido.notificationhub.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return service.create(notification);
    }

    @GetMapping
    public List<Notification> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Notification findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Notification updateNotification(@PathVariable long id, @RequestBody Notification notification) {
        return service.update(id, notification);
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
