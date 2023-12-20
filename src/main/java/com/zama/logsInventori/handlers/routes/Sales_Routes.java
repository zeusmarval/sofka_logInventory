package com.zama.logsInventori.handlers.routes;

import com.zama.logsInventori.usesCases.sales.GetSaleForType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Sales_Routes {
    @Autowired
    private GetSaleForType getSaleForType;
    @Bean
    public RouterFunction<ServerResponse> SalesRoutes() {
        return RouterFunctions.route()
                .GET("/sale/{typeSale}", accept(MediaType.APPLICATION_JSON), getSaleForType::apply)
                .build();
    }
}
