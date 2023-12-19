package com.zama.logsInventori.utils.Mappers;

import com.zama.logsInventori.Models.DTO.MessageDTO;
import com.zama.logsInventori.Models.Message;
import com.zama.logsInventori.Models.Product;

import java.time.LocalDateTime;

public class MessageMapper {

    public static Message toEntity(Message entity){
        Message msg = new Message();
        msg.setId(entity.getId());
        msg.setPublishDate(entity.getPublishDate());
        msg.setAction(entity.getAction());
        msg.setTypeMessage(entity.getTypeMessage());
        msg.setMessage(entity.getMessage());
        return msg;
    }

    public static Message toMessage(MessageDTO message){
        Message msg = new Message();
        msg.setPublishDate(LocalDateTime.parse(message.getPublishDate()));
        msg.setAction(message.getAction());
        msg.setTypeMessage(message.getTypeMessage());
        msg.setMessage(message.getMessage());
        return msg;
    }

    public static Message toMessageWhitProduct(MessageDTO message){
        Message msg = new Message();
        msg.setPublishDate(LocalDateTime.parse(message.getPublishDate()));
        msg.setAction(message.getAction());
        msg.setTypeMessage(message.getTypeMessage());
        msg.setMessage(message.getMessage());
        msg.setProduct(message.getProduct());
        return msg;
    }

    public static MessageDTO toDTO(Message message){
        MessageDTO msg = new MessageDTO();
        msg.setPublishDate(message.getPublishDate().toString());
        msg.setAction(message.getAction());
        msg.setTypeMessage(message.getTypeMessage());
        msg.setMessage(message.getMessage());
        return msg;
    }

}
