package br.com.via.explojista.dojo.ssenotificationserver.service;

import br.com.via.explojista.dojo.ssenotificationserver.dto.NotificationRequest;
import br.com.via.explojista.dojo.ssenotificationserver.model.NotificationModel;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

@Service
public interface NotificationService {

    NotificationModel save(NotificationRequest notificationRequest);

    List<NotificationModel> findAllByRecipientId(Long recipientId);

    SseEmitter sseSubscribe(Long recipientId);

    void pushNotification(NotificationModel notificationModel);
}
