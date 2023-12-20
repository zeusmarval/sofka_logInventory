package com.zama.logsInventori.usesCases.all;

import com.zama.logsInventori.Models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GetAll {

    @Autowired
    private MessagesResource messagesResource;

    public Mono<ServerResponse> apply(ServerRequest request) {
        int page = Integer.parseInt(request.queryParam("page").orElse("0"));
        int size = Integer.parseInt(request.queryParam("size").orElse("10"));

        Flux<Message> allMessages = messagesResource.getAllMessagesPaginated(page, size);

        return allMessages.collectList().flatMap(messages -> {
            System.out.println(messages);
            return ServerResponse.ok()
                    .body(allMessages, Message.class)
                    .switchIfEmpty(ServerResponse.notFound().build())
                    .onErrorResume(this::handleError);
        });

    }

    private Mono<ServerResponse> handleError(Throwable error) {
        String messageError = "Error al obtener los mensajes: " + error;

        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(messageError));
    }

}
