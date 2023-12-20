package com.zama.logsInventori.usesCases.sales;

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
public class GetSaleForType {

    @Autowired
    private SalesResource salesResource;

    public Mono<ServerResponse> apply(ServerRequest request) {
        String typeSale = request.pathVariable("typeSale");

        Flux<Message> movementsProduct = salesResource.getSalesForType(typeSale);

        return ServerResponse.ok()
                .body(movementsProduct, Message.class)
                .switchIfEmpty(ServerResponse.notFound().build())
                .onErrorResume(this::handleError);
    }

    private Mono<ServerResponse> handleError(Throwable error) {
        String messageError = "Error al obtener los productos: " + error;
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(messageError));
    }

}
