package com.florian935.client.share.router.service;

import com.florian935.client.share.router.domain.TransactionEvent;
import reactor.core.publisher.Flux;

public interface TransactionService {

    Flux<TransactionEvent> transactionStream();
}
