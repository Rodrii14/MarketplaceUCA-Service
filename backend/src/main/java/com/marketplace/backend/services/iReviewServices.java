package com.marketplace.backend.services;

import com.marketplace.backend.domain.dto.review.CreateReviewDto;
import com.marketplace.backend.domain.dto.review.ResponseReviewDto;
import com.marketplace.backend.domain.entities.User;

import java.util.List;

public interface iReviewServices {

    User getUserSession();

    ResponseReviewDto addReview(CreateReviewDto reviewDto);

    ResponseReviewDto getReviewById(String id);

    List<ResponseReviewDto> getReviewsByProductId(String productId);

    List<ResponseReviewDto> getReviewsBySellerId(String sellerId);

    List<ResponseReviewDto> getReviewsByUser();

    ResponseReviewDto updateReview(String id, CreateReviewDto reviewDto);

    String deleteReview(String id);
}
