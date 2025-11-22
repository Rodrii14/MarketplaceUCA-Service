package com.marketplace.backend.repositories;

import com.marketplace.backend.domain.entities.Review;
import com.marketplace.backend.domain.entities.Product;
import com.marketplace.backend.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface iReviewRepository extends iGenericRepository<Review, UUID> {

    Review findReviewById(UUID id);
    List<Review> findReviewsBySeller(User seller);
    List<Review> findReviewsByAuthor(User author);
    List<Review> findReviewsByProduct(Product product);
}
