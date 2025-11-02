package com.marketplace.backend.services.impl;

import com.marketplace.backend.domain.dto.likes.ResponseLikes;
import com.marketplace.backend.domain.entities.Likes;
import com.marketplace.backend.domain.entities.Product;
import com.marketplace.backend.domain.entities.User;
import com.marketplace.backend.exceptions.likes.LikesNotFound;
import com.marketplace.backend.exceptions.product.ProductNotFound;
import com.marketplace.backend.exceptions.user.UserNotFound;
import com.marketplace.backend.repositories.iLikesRepository;
import com.marketplace.backend.repositories.iProductRepository;
import com.marketplace.backend.repositories.iUserRepository;
import com.marketplace.backend.services.iLikesServices;
import com.marketplace.backend.utils.mappers.LikesMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LikesServicesImpl implements iLikesServices {

    private final iLikesRepository likesRepository;
    private final iProductRepository productRepository;
    private final iUserRepository userRepository;
    private final LikesMappers mappers;

    @Override
    public ResponseLikes addLikes(String productId) {
        Product product = productRepository.findProductById(UUID.fromString(productId));
        User user = getUserSession();

        if (product == null) {
            throw new ProductNotFound();
        }

        Likes likes = new Likes();
        user.addLikes(likes);
        product.addLikes(likes);
        likesRepository.save(likes);
        return mappers.castLikesData(likes);
    }

    @Override
    public void deleteLikes(String likesId) {
        Likes likes = likesRepository.findLikesById(UUID.fromString(likesId));

        if (likes == null) {
            throw new LikesNotFound();
        }

        User user = likes.getUser();
        Product product = likes.getProduct();
        user.removeLikes(likes);
        product.removeLikes(likes);
        likesRepository.delete(likes);
    }

    @Override
    public List<ResponseLikes> getByProductId(String productId) {
        List<Likes> likes = likesRepository.findByProductId(UUID.fromString(productId));

        return mappers.castLikesDataList(likes);
    }

    @Override
    public List<ResponseLikes> getByUser() {
        User user = getUserSession();
        List<Likes> likes = likesRepository.findByUser(user);

        return mappers.castLikesDataList(likes);
    }

    @Override
    public User getUserSession(){
        User userNoSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userNoSession.getUsername());

        if (user == null){
            throw new UserNotFound();
        }

        return user;
    }
}
