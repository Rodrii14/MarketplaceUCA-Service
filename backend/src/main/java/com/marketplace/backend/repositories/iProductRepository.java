package com.marketplace.backend.repositories;

import com.marketplace.backend.domain.entities.Category;
import com.marketplace.backend.domain.entities.Product;
import com.marketplace.backend.domain.entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface iProductRepository extends iGenericRepository<Product, UUID> {

    List<Product> findProductByActive(Boolean active);
    Product findProductById(UUID id);
    List<Product> findProductsByUserAndActive(User user, Boolean active);
    List<Product> findProductsByCategoryAndActive(Category category, Boolean active);
}
