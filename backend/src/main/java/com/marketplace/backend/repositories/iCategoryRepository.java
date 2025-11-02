package com.marketplace.backend.repositories;

import com.marketplace.backend.domain.entities.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface iCategoryRepository extends iGenericRepository<Category, UUID> {

    @Query("SELECT C FROM Category C")
    List<Category> findAllCategories();
    Category findCategoryByName(String name);
}
