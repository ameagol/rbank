package com.gellman.rbank.strategy;

import com.gellman.rbank.request.TransactionRequest;
import com.gellman.rbank.response.TransactionResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class PaymentStrategy implements TransactionStrategy {
    @Override
    public TransactionResponse execute(TransactionRequest request) {
        System.out.println("Processing payment of $" + request.getAmount());
        return new TransactionResponse(
                request.getId(),
                request.getCreateDate(),
                request.toString()
        );
    }
}
