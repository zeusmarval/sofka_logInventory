package com.zama.logsInventori;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.*;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_PRODUCT = "product-queue";
    public static final String QUEUE_SALES = "sales-queue";
    public static final String QUEUE_GETS = "gets-queue";
    public static final String QUEUE_PRODCUCT_ERRORS = "product-errors-queue";
    public static final String QUEUE_SALES_ERRORS = "sales-errors-queue";
    public static final String QUEUE_GETS_ERRORS = "gets-errors-queue";
    public static final String EXCHANGE_NAME = "inventory-exchange";
    public static final String ROUTING_KEY_PRODUCT = "product.routing.key";
    public static final String ROUTING_KEY_SALES = "sales.routing.key";
    public static final String ROUTING_KEY_GETS = "gets.routing.key";
    public static final String ROUTING_KEY_PRODUCT_ERROR = "errors.product.routing.key";
    public static final String ROUTING_KEY_SALES_ERROR = "errors.sales.routing.key";
    public static final String ROUTING_KEY_GETS_ERROR = "errors.gets.routing.key";
    @Value("${URI_NAME}")
    private String URI_NAME;
    @Bean
    public ConnectionFactory connectionFactory() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.useNio();
        connectionFactory.setUri(URI_NAME);
        return connectionFactory;
    }

    @Bean
    public Mono<Connection> connectionMono(@Value("spring.application.name") String name, ConnectionFactory connectionFactory)  {
        return Mono.fromCallable(() -> connectionFactory.newConnection(name)).cache();
    }

    @Bean
    public ReceiverOptions receiverOptions(Mono<Connection> connectionMono) {
        return new ReceiverOptions()
                .connectionMono(connectionMono);
    }

    @Bean
    public Receiver receiver(ReceiverOptions receiverOptions) {
        return RabbitFlux.createReceiver(receiverOptions);
    }
}

