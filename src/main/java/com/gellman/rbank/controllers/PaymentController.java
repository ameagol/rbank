package com.gellman.rbank.controllers;

import com.gellman.rbank.blockchain.entities.Block;
import com.gellman.rbank.blockchain.services.BlockchainService;
import com.gellman.rbank.transactions.Transaction;
import com.gellman.rbank.request.PaymentRequest;
import com.gellman.rbank.response.TransactionResponse;
import com.gellman.rbank.strategy.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private BlockchainService blockchainService;
    @Autowired
    private PaymentStrategy paymentStrategy;

    @PostMapping
    public ResponseEntity<Block> createPayment(@RequestBody PaymentRequest paymentRequest) {
        return Optional.ofNullable(paymentRequest)
                .map(request -> {
                    Transaction transaction = new Transaction(paymentStrategy);
                    TransactionResponse response = transaction.executeTransaction(request);
                    return blockchainService.createBlock(request.getAccountOrigin(), response);
                })
                .map(block -> ResponseEntity.status(HttpStatus.CREATED).body(block))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    @GetMapping
    public ResponseEntity<Block> getBlockchain(@RequestParam String accountCode) {
        return ResponseEntity.ok(blockchainService.getBlockchain(accountCode));
    }
}
