package com.gellman.rbank.strategy;

import com.gellman.rbank.request.TransactionRequest;
import com.gellman.rbank.response.TransactionResponse;

public interface TransactionStrategy {
    TransactionResponse execute(TransactionRequest request);
}
