package com.marketplace.backend.utils.mappers;

import com.marketplace.backend.domain.dto.category.ResponseCategoryDto;
import com.marketplace.backend.domain.entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMappers {

    public ResponseCategoryDto castCategoryData(Category category){
        ResponseCategoryDto response = new ResponseCategoryDto();

        response.setName(category.getName());
        response.setDescription(category.getDescription());

        return response;
    }

    public List<ResponseCategoryDto> getCastedCategoryList(List<Category> category){
        List<ResponseCategoryDto> responseCategoryList = new ArrayList<>();

        if (!category.isEmpty()) {
            for (Category cat : category) {
                responseCategoryList.add(castCategoryData(cat));
            }

        }

        return responseCategoryList;
    }
}
