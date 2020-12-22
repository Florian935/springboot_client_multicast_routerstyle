package com.florian935.client.share.router.service;

import com.florian935.client.share.router.domain.SupplierTransaction;
import com.florian935.client.share.router.domain.SupplierTransactionEvent;
import reactor.core.publisher.Flux;

public interface SupplierTransactionService {

    Flux<SupplierTransaction> transactionSupplierStream();
    Flux<SupplierTransactionEvent> transactionSupplierEventStream();
}
