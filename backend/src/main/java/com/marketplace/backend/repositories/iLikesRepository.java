package com.marketplace.backend.repositories;

import com.marketplace.backend.domain.entities.Likes;
import com.marketplace.backend.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface iLikesRepository extends iGenericRepository<Likes, UUID> {

    Likes findLikesById(UUID id);
    List<Likes> findByProductId(UUID productId);
    List<Likes> findByUser(User user);
}
