package com.marketplace.backend.services.impl;

import com.marketplace.backend.domain.dto.category.CreateCategoryDto;
import com.marketplace.backend.domain.dto.category.ResponseCategoryDto;
import com.marketplace.backend.domain.dto.category.UpdateCategoryDto;
import com.marketplace.backend.domain.entities.Category;
import com.marketplace.backend.exceptions.category.CategoryAlreadyExists;
import com.marketplace.backend.exceptions.category.CategoryNotFound;
import com.marketplace.backend.repositories.iCategoryRepository;
import com.marketplace.backend.services.iCategoryServices;
import com.marketplace.backend.utils.mappers.CategoryMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServicesImpl implements iCategoryServices {

    private final iCategoryRepository iCategoryRepository;
    private final CategoryMappers categoryMappers;


    @Override
    public ResponseCategoryDto createCategory(CreateCategoryDto categoryDto) {
        Category categoryToVerify = iCategoryRepository.findCategoryByName(categoryDto.getName());

        if (categoryToVerify != null) {
            throw new CategoryAlreadyExists();
        }

        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        iCategoryRepository.save(category);
        return categoryMappers.castCategoryData(category);
    }

    @Override
    public ResponseCategoryDto updateCategory(UpdateCategoryDto categoryDto) {
        Category categoryToUpdate = iCategoryRepository.findCategoryByName(categoryDto.getName());

        if(categoryToUpdate == null){
            throw new CategoryNotFound();
        }

        categoryToUpdate.setName(categoryDto.getNewName());
        categoryToUpdate.setDescription(categoryDto.getNewDescription());

        iCategoryRepository.save(categoryToUpdate);
        return categoryMappers.castCategoryData(categoryToUpdate);
    }

    @Override
    public List<ResponseCategoryDto> findAllCategories() {
        List<Category> categories = iCategoryRepository.findAllCategories();
        return categoryMappers.getCastedCategoryList(categories);
    }

    @Override
    public ResponseCategoryDto findCategoryByName(String name) {
        Category category = iCategoryRepository.findCategoryByName(name);

        if(category == null){
            throw new CategoryNotFound();
        }

        return categoryMappers.castCategoryData(category);
    }
}
