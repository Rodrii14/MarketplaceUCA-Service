package com.marketplace.backend.services;

import com.marketplace.backend.domain.dto.product.CreateProductDto;
import com.marketplace.backend.domain.dto.product.ResponseProductDto;
import com.marketplace.backend.domain.dto.product.UpdateProductDto;
import com.marketplace.backend.domain.entities.User;

import java.util.List;

public interface iProductServices {

    ResponseProductDto createProduct(CreateProductDto product);
    ResponseProductDto updateProduct(UpdateProductDto product);
    String activateProduct(String id);
    User getUserSession();

    List<ResponseProductDto> getProductsByActive(Boolean active);
    ResponseProductDto getProductById(String id);
    List<ResponseProductDto> getProductsByUserAndActive(String email, Boolean active);
    List<ResponseProductDto> getProductsByAuthUserAndActive(Boolean active);
    List<ResponseProductDto> getProductsByCategoryAndActive(String categoryName, Boolean active);

    void deleteProduct(String id);
}
