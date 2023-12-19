package com.zama.logsInventori;

import com.google.gson.Gson;
import com.rabbitmq.client.Connection;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class LogsInventoriApplication {

	@Autowired
	private Mono<Connection> connectionMono;

	@Bean
	public Gson createGson(){
		return new Gson();
	}

	public static void main(String[] args) {
		SpringApplication.run(LogsInventoriApplication.class, args);
	}

	@PreDestroy
	public void closeRabbit() {
		connectionMono.doOnSuccess(connection -> {
			try {
				connection.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
	}

}
