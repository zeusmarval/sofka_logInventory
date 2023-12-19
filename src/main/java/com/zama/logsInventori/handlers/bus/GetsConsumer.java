package com.zama.logsInventori.handlers.bus;

import com.google.gson.Gson;
import com.zama.logsInventori.Models.DTO.MessageDTO;
import com.zama.logsInventori.RabbitConfig;
import com.zama.logsInventori.drivenAdapters.repository.Message_Repository;
import com.zama.logsInventori.utils.Mappers.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

//@Component
//@Order(2)
public class GetsConsumer implements CommandLineRunner {
    @Autowired
    private Receiver receiver;
    @Autowired
    private Gson gson;
    @Autowired
    private Message_Repository messageRepository;

    @Override
    public void run(String... args) throws Exception {

        receiver.consumeAutoAck(RabbitConfig.QUEUE_PRODUCT)
                .map(messageConsumer -> {

                    MessageDTO message = gson.fromJson(
                            new String(messageConsumer.getBody()), MessageDTO.class);

                    messageRepository.save(MessageMapper.toMessage(message)).subscribe();

                    return messageConsumer;

                }).subscribe();

    }
}
