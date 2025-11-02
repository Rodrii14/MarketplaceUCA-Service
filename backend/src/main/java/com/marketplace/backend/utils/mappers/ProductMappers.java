package com.marketplace.backend.utils.mappers;

import com.marketplace.backend.domain.dto.product.ResponseProductDto;
import com.marketplace.backend.domain.entities.Images;
import com.marketplace.backend.domain.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMappers {

    public ResponseProductDto castProductData(Product product) {
        ResponseProductDto response = new ResponseProductDto();

        response.setId(product.getId());
        response.setProduct(product.getProduct());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setCondition(product.getCondition());
        response.setActive(product.getActive());

        for (Images image : product.getImages()) {
            response.getImages().add(image.getPath());
        }

        response.setCategoryName(product.getCategory().getName());
        response.setUserName(product.getUser().getUsername());
        response.setPhoneNumber(product.getUser().getPhoneNumber());

        return response;
    }

    public List<ResponseProductDto> getCastedProductList(List<Product> products) {
        List<ResponseProductDto> responseProductList = new ArrayList<>();

        if (!products.isEmpty()) {
            for (Product product : products) {
                responseProductList.add(castProductData(product));
            }
        }

        return responseProductList;
    }
}
