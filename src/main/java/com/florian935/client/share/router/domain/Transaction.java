package com.florian935.client.share.router.domain;

import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Transaction {

    private String id;
    private Instant instant;
    private float price;
}
