package br.com.via.explojista.dojo.ssenotificationserver.event;

import br.com.via.explojista.dojo.ssenotificationserver.model.NotificationModel;
import org.springframework.context.ApplicationEvent;

public class NotificationEvent extends ApplicationEvent {

    private NotificationModel notificationModel;

    public NotificationEvent(Object source, NotificationModel notificationModel) {
        super(source);
        this.notificationModel = notificationModel;
    }

    public NotificationModel getNotificationModel() {
        return notificationModel;
    }
}
