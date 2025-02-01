package com.gellman.rbank.blockchain.services;

import com.gellman.rbank.blockchain.entities.Block;
import com.gellman.rbank.blockchain.repositories.BlockRepository;
import com.gellman.rbank.response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class BlockchainService {

    @Autowired
    private BlockRepository blockRepository;

    public Block createBlock(String accountCode, TransactionResponse transactionResponse) {
        List<Block> blocks = blockRepository.findByAccountCode(accountCode);
        System.out.println("BlockChain para a Conta: " + accountCode + " Total de Blocks: " + blocks.size());
        Block previousBlock = blocks.isEmpty() ? new Block(accountCode, "Genesis") : blocks.get(blocks.size() - 1);
        Block newBlock = new Block(accountCode, transactionResponse.getDetails(), previousBlock);
        return blockRepository.save(newBlock);
    }

    public Block getBlockchain(String accountCode) {
        return Optional.ofNullable(blockRepository.findBlocksByAccountCode(accountCode))
                .filter(blocks -> !blocks.isEmpty())
                .map(blocks -> {
                    IntStream.range(1, blocks.size())
                            .forEach(i -> blocks.get(i).setPreviousBlock(blocks.get(i - 1)));
                    return blocks.get(blocks.size() - 1);
                })
                .orElse(null);
    }
}

