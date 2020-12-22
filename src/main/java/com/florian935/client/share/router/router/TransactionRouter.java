package com.florian935.client.share.router.router;

import com.florian935.client.share.router.handler.TransactionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TransactionRouter {

    @Bean
    public RouterFunction<ServerResponse> transactionRoutes(
            final TransactionHandler transactionHandler) {
        return nest(
                path("/transaction"),
                route()
                        .GET("/SSE", transactionHandler::transactionStreamSSE)
                        .GET("/supplier/SSE", transactionHandler::supplierTransactionSSE)
                        .GET("/supplier", transactionHandler::supplierTransaction)
                        .GET("/supplier/event/SSE", transactionHandler::supplierTransactionEventStreamSSE)
                        .build()
        );
    }

}
