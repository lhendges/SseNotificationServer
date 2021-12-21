package br.com.via.explojista.dojo.ssenotificationserver.controller;

import br.com.via.explojista.dojo.ssenotificationserver.dto.NotificationRequest;
import br.com.via.explojista.dojo.ssenotificationserver.model.NotificationModel;
import br.com.via.explojista.dojo.ssenotificationserver.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notification")
public class NotificationManagementController {

    private final NotificationService notificationService;

    public NotificationManagementController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<NotificationModel> create(@RequestBody NotificationRequest notificationRequest) {
        return ResponseEntity.ok(notificationService.save(notificationRequest));
    }

    @GetMapping
    public ResponseEntity<List<NotificationModel>> findAllByRecipient(@RequestParam(name = "recipientId") Long recipientId) {
        return ResponseEntity.ok(notificationService.findAllByRecipientId(recipientId));
    }
}
