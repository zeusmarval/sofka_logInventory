package com.zama.logsInventori.handlers.routes;

import com.zama.logsInventori.usesCases.all.GetAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Messages_Routes {

    @Autowired
    private GetAll getAll;
    @Bean
    public RouterFunction<ServerResponse> MessagesRoutes() {
        return RouterFunctions.route()
                .GET("/get/all", accept(MediaType.APPLICATION_JSON), getAll::apply)
                .build();
    }
}
