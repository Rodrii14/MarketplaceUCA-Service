package com.marketplace.backend.controllers;

import com.marketplace.backend.domain.dto.category.CreateCategoryDto;
import com.marketplace.backend.domain.dto.GeneralResponse;
import com.marketplace.backend.domain.dto.category.ResponseCategoryDto;
import com.marketplace.backend.domain.dto.category.UpdateCategoryDto;
import com.marketplace.backend.services.iCategoryServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CategoryControllers {

    private final iCategoryServices iCategoryServices;

    @GetMapping("category/all")
    public ResponseEntity<GeneralResponse> findAllCategories() {
        List<ResponseCategoryDto> resp = iCategoryServices.findAllCategories();
        return GeneralResponse.builder()
                .data(resp)
                .message("Ok")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("category/name")
    public ResponseEntity<GeneralResponse> findCategoryByName(@RequestParam("name") String name) {
        ResponseCategoryDto resp = iCategoryServices.findCategoryByName(name);
        return GeneralResponse.builder()
                .data(resp)
                .message("Ok")
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("admin/category/create")
    public ResponseEntity<GeneralResponse> createCategory(@RequestBody @Valid CreateCategoryDto category) {
        ResponseCategoryDto resp = iCategoryServices.createCategory(category);
        return GeneralResponse.builder()
                .data(resp)
                .message("Category Created")
                .status(HttpStatus.CREATED)
                .build();
    }

    @PatchMapping("admin/category/update")
    public ResponseEntity<GeneralResponse> updateCategory(@RequestBody @Valid UpdateCategoryDto category) {
        ResponseCategoryDto resp = iCategoryServices.updateCategory(category);
        return GeneralResponse.builder()
                .data(resp)
                .message("Category Updated")
                .status(HttpStatus.ACCEPTED)
                .build();
    }

}
