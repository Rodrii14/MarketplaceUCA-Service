package com.marketplace.backend.services;

import com.marketplace.backend.domain.entities.Images;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface iImagesServices {

    Images createImages(MultipartFile files);
    List<Images> getImages();
}
