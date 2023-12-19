package com.zama.logsInventori.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private LocalDateTime publishDate;
    private String action;
    private String typeMessage;
    private String message;
    private List<Product> product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Message() {
    }

    public Message(String action, String typeMessage, String message) {
        this.action = action;
        this.typeMessage = typeMessage;
        this.message = message;
    }

    public Message(String id, LocalDateTime publishDate, String action, String typeMessage, String message, List<Product> product) {
        this.id = id;
        this.publishDate = publishDate;
        this.action = action;
        this.typeMessage = typeMessage;
        this.message = message;
        this.product = product;
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
