package br.com.via.explojista.dojo.ssenotificationserver.dto;

import java.time.OffsetDateTime;

public class NotificationRequest {

    private Long recipientId;
    private String text;
    private OffsetDateTime createdAt = OffsetDateTime.now();

    public NotificationRequest(Long recipientId, String text) {
        this.recipientId = recipientId;
        this.text = text;
        this.createdAt = OffsetDateTime.now();
    }

    public NotificationRequest() {

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
}
