package com.zama.logsInventori.handlers.routes;

import com.zama.logsInventori.usesCases.erros.GetErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Error_Routes {

    @Autowired
    private GetErrors getErrors;

    @Bean
    public RouterFunction<ServerResponse> ErrorRoutes() {
        return RouterFunctions.route()
                .GET("/get/errors", accept(MediaType.APPLICATION_JSON), getErrors::apply)
                .build();
    }
}
