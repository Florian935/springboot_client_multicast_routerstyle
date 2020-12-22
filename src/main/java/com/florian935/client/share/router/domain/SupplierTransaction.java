package com.florian935.client.share.router.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SupplierTransaction {

    private Supplier supplier;
    private TransactionEvent transactionEvent;
}
