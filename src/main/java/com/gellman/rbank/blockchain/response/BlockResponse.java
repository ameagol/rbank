package com.gellman.rbank.blockchain.response;

import com.gellman.rbank.blockchain.entities.Block;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockResponse {
    private String hash;
    private String accountCode;
    private long timestamp;
    private String data;
    private Block proviousBlock;
}
