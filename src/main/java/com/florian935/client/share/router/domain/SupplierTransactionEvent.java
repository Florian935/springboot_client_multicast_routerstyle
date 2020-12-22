package com.florian935.client.share.router.domain;

import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SupplierTransactionEvent {

    private long supplierCounter;
    private String username;
    private float price;
    private Instant instant;
}
