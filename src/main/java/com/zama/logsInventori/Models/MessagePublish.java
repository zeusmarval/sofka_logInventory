package com.zama.logsInventori.Models;

import java.time.LocalDateTime;

public class MessagePublish {
    private LocalDateTime publishDate;
    private String action;
    private String typeMessage;
    private String message;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public MessagePublish() {
    }

    public MessagePublish(String action, String typeMessage, String message) {
        this.action = action;
        this.typeMessage = typeMessage;
        this.message = message;
    }

    @Override
    public String toString() {
        return "PublishMessage{" +
                "publishDate=" + publishDate +
                ", action='" + action + '\'' +
                ", typeMessage='" + typeMessage + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
