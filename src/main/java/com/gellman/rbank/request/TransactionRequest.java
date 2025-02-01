package com.gellman.rbank.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class TransactionRequest {
    private UUID id;
    private Date createDate;
    private Double amount;
    private String accountOrigin;
    private String accountDestiny;
}
