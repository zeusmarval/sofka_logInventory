package com.zama.logsInventori.handlers.bus;

import com.google.gson.Gson;
import com.zama.logsInventori.RabbitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

@Component
@Order(1)
public class SalesConsumer implements CommandLineRunner {
    @Autowired
    private Receiver receiver;
    @Autowired
    private Gson gson;
    @Override
    public void run(String... args) throws Exception {

        receiver.consumeAutoAck(RabbitConfig.QUEUE_SALES)
                .map(message -> {
                    System.out.println(message);
                    return message;

                }).subscribe();

    }
}
