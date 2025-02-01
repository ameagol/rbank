package com.gellman.rbank.transactions;

import com.gellman.rbank.request.TransactionRequest;
import com.gellman.rbank.response.TransactionResponse;
import com.gellman.rbank.strategy.TransactionStrategy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Transaction {

    private TransactionStrategy strategy;

    public Transaction(TransactionStrategy strategy) {
        this.strategy = strategy;
    }

    public TransactionResponse executeTransaction(TransactionRequest request) {
        return Optional.ofNullable(strategy)
                .map(s -> s.execute(request))
                .orElseThrow(() -> new IllegalStateException("No transaction strategy set."));
    }
}