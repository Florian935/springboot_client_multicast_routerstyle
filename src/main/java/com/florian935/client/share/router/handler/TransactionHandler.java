package com.florian935.client.share.router.handler;

import com.florian935.client.share.router.domain.TransactionEvent;
import com.florian935.client.share.router.domain.SupplierTransaction;
import com.florian935.client.share.router.domain.SupplierTransactionEvent;
import com.florian935.client.share.router.service.SupplierTransactionService;
import com.florian935.client.share.router.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class TransactionHandler {

    private final TransactionService transactionService;
    private final SupplierTransactionService supplierTransactionService;

    public Mono<ServerResponse> transactionStreamSSE(final ServerRequest request) {
        return ok()
                .contentType(TEXT_EVENT_STREAM)
                .body(
                        transactionService.transactionStream(),
                        TransactionEvent.class
                );
    }

    public Mono<ServerResponse> supplierTransactionSSE(final ServerRequest request) {
        return ok()
                .contentType(TEXT_EVENT_STREAM)
                .body(
                        supplierTransactionService.transactionSupplierStream(),
                        SupplierTransaction.class
                );
    }

    public Mono<ServerResponse> supplierTransaction(final ServerRequest server) {
        return ok()
                .contentType(APPLICATION_STREAM_JSON)
                .body(
                        supplierTransactionService.transactionSupplierStream(),
                        SupplierTransaction.class
                );
    }

    public Mono<ServerResponse> supplierTransactionEventStreamSSE(
            final ServerRequest server) {
        return ok()
                .contentType(TEXT_EVENT_STREAM)
                .body(
                        supplierTransactionService.transactionSupplierEventStream(),
                        SupplierTransactionEvent.class
                );
    }
}
