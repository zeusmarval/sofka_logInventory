package com.zama.logsInventori.usesCases.erros;

import com.zama.logsInventori.Models.Message;
import com.zama.logsInventori.drivenAdapters.repository.Message_Repository;
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
public class GetErrors {

    @Autowired
    private ErrorResource errorResource;

    public Mono<ServerResponse> apply(ServerRequest request) {

        Flux<Message> allErrors = errorResource.getErros();

        return allErrors.collectList().flatMap(products -> {
            //publisherGets.product(products);
            return ServerResponse.ok()
                    .body(allErrors, Message.class)
                    .switchIfEmpty(ServerResponse.notFound().build())
                    .onErrorResume(this::handleError);
        });

    }

    private Mono<ServerResponse> handleError(Throwable error) {
        String messageError = "Error al obtener los errores: " + error;
        //publisherGets.errors(messageError);
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(messageError));
    }
}
