package com.zama.logsInventori.Models.DTO;

public class MessagePublishDTO {
    private String publishDate;
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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
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
