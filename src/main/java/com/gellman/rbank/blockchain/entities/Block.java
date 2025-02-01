package com.gellman.rbank.blockchain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.UUID;


@Node
@Data
@NoArgsConstructor
public class Block {
    @Id
    private String hash;
    private String accountCode;
    private long timestamp;
    private String data;

    @Relationship(type = "PREVIOUS_BLOCK", direction = Relationship.Direction.OUTGOING)
    private Block previousBlock;

    public Block(String accountCode, String data) {
        this.hash = UUID.randomUUID().toString();
        this.accountCode = accountCode;
        this.timestamp = System.currentTimeMillis();
        this.data = data;
        this.previousBlock = null;
    }

    public Block(String accountCode, String data, Block previousBlock) {
        this.hash = UUID.randomUUID().toString();
        this.accountCode = accountCode;
        this.timestamp = System.currentTimeMillis();
        this.data = data;
        this.previousBlock = previousBlock;
    }
}

