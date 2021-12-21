package br.com.via.explojista.dojo.ssenotificationserver.service;

import br.com.via.explojista.dojo.ssenotificationserver.dto.NotificationRequest;
import br.com.via.explojista.dojo.ssenotificationserver.model.NotificationModel;
import br.com.via.explojista.dojo.ssenotificationserver.repository.NotificationRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Long TIMEOUT = -1L;
    private final NotificationRepository notificationRepository;

    private final ConcurrentHashMap<Long, SseEmitter> emitters = new ConcurrentHashMap<>();

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public NotificationModel save(NotificationRequest notificationRequest) {
        NotificationModel notification = new NotificationModel(notificationRequest.getRecipientId(), notificationRequest.getText());

        return notificationRepository.save(notification);
    }

    @Override
    public List<NotificationModel> findAllByRecipientId(Long recipientId) {
        return notificationRepository.findAllByRecipientIdAndReadFalse(recipientId);
    }

    @Override
    public SseEmitter sseSubscribe(Long recipientId) {
        return getSSEInstance(recipientId);
    }

    @Override
    public void pushNotification(NotificationModel notificationModel) {
        SseEmitter emitter = getSSEInstance(notificationModel.getRecipientId());
        try {
            emitter.send(notificationModel, MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            emitter.complete();
            emitters.remove(notificationModel.getRecipientId());
            e.printStackTrace();
        }
    }

    private SseEmitter getSSEInstance(Long recipientId) {
        SseEmitter emitter = emitters.getOrDefault(recipientId, new SseEmitter(TIMEOUT));
        emitters.put(recipientId, emitter);
        return emitter;
    }
}
