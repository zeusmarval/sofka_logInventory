package com.zama.logsInventori.utils.Mappers;

import com.zama.logsInventori.Models.DTO.MessagePublishDTO;
import com.zama.logsInventori.Models.MessagePublish;

public class MessageMapper {

    public static MessagePublish toEntity(MessagePublish message){
        MessagePublish msg = new MessagePublish();
        msg.setPublishDate(message.getPublishDate());
        msg.setAction(message.getAction());
        msg.setTypeMessage(message.getTypeMessage());
        msg.setMessage(message.getMessage());
        return msg;
    }

    public static MessagePublishDTO toDTO(MessagePublish message){
        MessagePublishDTO msg = new MessagePublishDTO();
        msg.setPublishDate(message.getPublishDate().toString());
        msg.setAction(message.getAction());
        msg.setTypeMessage(message.getTypeMessage());
        msg.setMessage(message.getMessage());
        return msg;
    }

}
