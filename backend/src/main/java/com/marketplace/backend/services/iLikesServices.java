package com.marketplace.backend.services;

import com.marketplace.backend.domain.dto.likes.ResponseLikes;
import com.marketplace.backend.domain.entities.Likes;
import com.marketplace.backend.domain.entities.User;

import java.util.List;

public interface iLikesServices {

    User getUserSession();
    ResponseLikes addLikes(String productId);
    void deleteLikes(String likesId);
    List<ResponseLikes> getByProductId(String productId);
    List<ResponseLikes> getByUser();
}
