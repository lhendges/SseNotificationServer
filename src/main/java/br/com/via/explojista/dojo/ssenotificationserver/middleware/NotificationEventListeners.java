package br.com.via.explojista.dojo.ssenotificationserver.middleware;

import br.com.via.explojista.dojo.ssenotificationserver.event.NotificationEvent;
import br.com.via.explojista.dojo.ssenotificationserver.service.NotificationService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventListeners implements ApplicationListener<NotificationEvent> {

    private NotificationService notificationService;

    public NotificationEventListeners(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void onApplicationEvent(NotificationEvent event) {
        notificationService.pushNotification(event.getNotificationModel());
    }
}
