package com.gellman.rbank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node
public class User {

    @Id
    private UUID id;
    private String name;
    private String address;
    private String countryId;
    private String countryUserId;
}

