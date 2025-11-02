package com.marketplace.backend.utils.mappers;

import com.marketplace.backend.domain.dto.likes.ResponseLikes;
import com.marketplace.backend.domain.entities.Likes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LikesMappers {

    public ResponseLikes castLikesData(Likes likes){
        ResponseLikes responseLikes = new ResponseLikes();
        responseLikes.setId(likes.getId());
        responseLikes.setName(likes.getUser().getName());
        responseLikes.setEmail(likes.getUser().getUsername());
        responseLikes.setProduct(likes.getProduct().getId());

        return  responseLikes;
    }

    public List<ResponseLikes> castLikesDataList(List<Likes> likes) {
        List<ResponseLikes> responseLikes = new ArrayList<>();

        for (Likes like : likes) {
            ResponseLikes resp = castLikesData(like);
            responseLikes.add(resp);
        }

        return responseLikes;
    }
}
