package com.marketplace.backend.controllers;

import com.marketplace.backend.domain.dto.GeneralResponse;
import com.marketplace.backend.domain.dto.likes.CreateLikes;
import com.marketplace.backend.domain.dto.likes.ResponseLikes;
import com.marketplace.backend.services.iLikesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikesControllers {

    private final iLikesServices likesServices;

    @PostMapping("/add")
    public ResponseEntity<GeneralResponse> addLike(@RequestBody CreateLikes createLikes) {
        ResponseLikes resp = likesServices.addLikes(createLikes.getProductId());

        return GeneralResponse.builder()
                .data(resp)
                .message("ok")
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> getLikes() {
        List<ResponseLikes> resp = likesServices.getByUser();

        return GeneralResponse.builder()
                .data(resp)
                .message("ok")
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/delete/{likesId}")
    public ResponseEntity<GeneralResponse> deleteLikes(@PathVariable String likesId) {
        likesServices.deleteLikes(likesId);

        return GeneralResponse.builder()
                .data(" ")
                .message("Deleted successfully")
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}
