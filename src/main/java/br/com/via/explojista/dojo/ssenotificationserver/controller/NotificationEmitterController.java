package br.com.via.explojista.dojo.ssenotificationserver.controller;

import br.com.via.explojista.dojo.ssenotificationserver.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@CrossOrigin
@RestController
@RequestMapping("/notification/emitter")
public class NotificationEmitterController {

    private final NotificationService notificationService;

    public NotificationEmitterController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/subscribe/{recipientId}")
    public SseEmitter getEmitter(@PathVariable Long recipientId) {
        return notificationService.sseSubscribe(recipientId);
    }
}
