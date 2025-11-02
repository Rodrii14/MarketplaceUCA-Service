package com.marketplace.backend.repositories;

import com.marketplace.backend.domain.entities.Token;

import java.util.UUID;

public interface iTokenRepository extends iGenericRepository<Token, UUID> {

    Token findByToken(String token);
}
