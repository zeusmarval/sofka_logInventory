package com.zama.logsInventori.handlers.routes;

import com.zama.logsInventori.usesCases.product.GetMovementsProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Product_Routes {

    @Autowired
    private GetMovementsProduct getMovementsProduct;
    @Bean
    public RouterFunction<ServerResponse> ProductRoutes() {
        return RouterFunctions.route()
                .GET("/product/{name}", accept(MediaType.APPLICATION_JSON), getMovementsProduct::apply)
                .build();
    }

}
