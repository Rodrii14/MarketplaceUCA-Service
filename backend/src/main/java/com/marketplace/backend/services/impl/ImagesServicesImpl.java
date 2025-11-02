package com.marketplace.backend.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.marketplace.backend.domain.entities.Images;
import com.marketplace.backend.exceptions.product.FailedToSaveImage;
import com.marketplace.backend.repositories.iImagesRepository;
import com.marketplace.backend.services.iImagesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImagesServicesImpl implements iImagesServices {

    private final iImagesRepository ImagesRepository;
    private final Cloudinary cloudinary;

    @Override
    public Images createImages(MultipartFile files) {
        Map<?, ?> UploadResult = null;
        try {
            UploadResult = cloudinary.uploader()
                    .upload(files.getBytes(), ObjectUtils.asMap(
                            "folder", "marketplace-uca",
                            "resource_type", "image"
                    ));
        } catch (IOException e) {
            throw new FailedToSaveImage();
        }

        String url = (String) UploadResult.get("secure_url");

        Images images = new Images();
        images.setPath(url);
        images.setFileName(files.getOriginalFilename());

        return images;
    }

    @Override
    public List<Images> getImages() {

        return ImagesRepository.findAll();
    }
}
