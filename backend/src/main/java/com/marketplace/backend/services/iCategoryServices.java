package com.marketplace.backend.services;

import com.marketplace.backend.domain.dto.category.CreateCategoryDto;
import com.marketplace.backend.domain.dto.category.ResponseCategoryDto;
import com.marketplace.backend.domain.dto.category.UpdateCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface iCategoryServices {

    ResponseCategoryDto createCategory(CreateCategoryDto categoryDto);
    ResponseCategoryDto updateCategory(UpdateCategoryDto categoryDto);
    @Query("SELECT C FROM Category C")
    List<ResponseCategoryDto> findAllCategories();
    ResponseCategoryDto findCategoryByName(String name);
}
