package com.gellman.rbank.blockchain.repositories;

import com.gellman.rbank.blockchain.entities.Block;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends Neo4jRepository<Block, String> {
    List<Block> findByAccountCode(String accountCode);

    @Query("MATCH (b:Block {accountCode: $accountCode}) RETURN b ORDER BY b.timestamp ASC")
    List<Block> findBlocksByAccountCode(@Param("accountCode") String accountCode);
}