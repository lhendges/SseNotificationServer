package br.com.via.explojista.dojo.ssenotificationserver.model;

import br.com.via.explojista.dojo.ssenotificationserver.middleware.NotificationPersistenceListener;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity(name = "Notification")
@EntityListeners(NotificationPersistenceListener.class)
public class NotificationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long recipientId;

    private String text;

    private OffsetDateTime createdAt = OffsetDateTime.now();

    private Boolean read;

    private OffsetDateTime readAt;

    public NotificationModel() {
    }

    public NotificationModel(Long recipientId, String text) {
        this.recipientId = recipientId;
        this.text = text;
        this.createdAt = OffsetDateTime.now();
        this.read = false;
    }

    public Long getId() {
        return id;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public OffsetDateTime getReadAt() {
        return readAt;
    }

    public void setReadAt(OffsetDateTime readAt) {
        this.readAt = readAt;
    }
}
