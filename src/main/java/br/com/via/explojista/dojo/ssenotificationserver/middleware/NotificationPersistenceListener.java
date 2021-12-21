package br.com.via.explojista.dojo.ssenotificationserver.middleware;

import br.com.via.explojista.dojo.ssenotificationserver.event.NotificationEvent;
import br.com.via.explojista.dojo.ssenotificationserver.model.NotificationModel;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;

@Component
public class NotificationPersistenceListener {

    private final ApplicationEventPublisher applicationEventPublisher;

    public NotificationPersistenceListener(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PostPersist
    void sendNotificationPersisted(NotificationModel notification) {
        applicationEventPublisher.publishEvent(new NotificationEvent(this, notification));
    }

}
