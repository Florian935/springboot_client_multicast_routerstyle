package com.florian935.client.share.router.service;

import com.florian935.client.share.router.domain.TransactionEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final WebClient webClient;
    private static final String BASE_API_STREAM_URL = "http://localhost:8081";
    private static final String TRANSACTION_URI = "/transaction";

    public TransactionServiceImpl() {
        this.webClient = WebClient.create(BASE_API_STREAM_URL);
    }

    @Override
    public Flux<TransactionEvent> transactionStream() {
        return webClient
                .get()
                .uri(TRANSACTION_URI)
                .retrieve()
                .bodyToFlux(TransactionEvent.class);
    }
}
