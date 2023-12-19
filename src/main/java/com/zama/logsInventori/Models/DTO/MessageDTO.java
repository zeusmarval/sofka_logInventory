package com.zama.logsInventori.Models.DTO;

import com.zama.logsInventori.Models.Product;

import java.util.List;

public class MessageDTO {
    private String publishDate;
    private String action;
    private String typeMessage;
    private String message;
    private List<Product> product;

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

    public List<Product> getProduct() {
        return product;
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
