package com.marketplace.backend.domain.dto.likes;

import lombok.Data;

import java.util.UUID;

@Data
public class ResponseLikes {

    private UUID id;
    private String name;
    private String email;
    private UUID product;
}
