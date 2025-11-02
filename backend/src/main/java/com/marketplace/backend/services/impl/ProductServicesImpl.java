package com.marketplace.backend.services.impl;

import com.marketplace.backend.domain.dto.product.CreateProductDto;
import com.marketplace.backend.domain.dto.product.ResponseProductDto;
import com.marketplace.backend.domain.dto.product.UpdateProductDto;
import com.marketplace.backend.domain.entities.Category;
import com.marketplace.backend.domain.entities.Images;
import com.marketplace.backend.domain.entities.Product;
import com.marketplace.backend.domain.entities.User;
import com.marketplace.backend.exceptions.product.ProductNotFound;
import com.marketplace.backend.repositories.iCategoryRepository;
import com.marketplace.backend.repositories.iProductRepository;
import com.marketplace.backend.repositories.iUserRepository;
import com.marketplace.backend.services.iImagesServices;
import com.marketplace.backend.services.iProductServices;
import com.marketplace.backend.utils.mappers.ProductMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServicesImpl implements iProductServices {

    private final iCategoryRepository categoryRepository;
    private final iProductRepository productRepository;
    private final iUserRepository userRepository;
    private final iImagesServices imagesServices;
    private final ProductMappers  productMappers;

    @Override
    public ResponseProductDto createProduct(CreateProductDto productDto) {

        Category category = categoryRepository.findCategoryByName(productDto.getCategoryName());

        User user = getUserSession();

        Product product = new Product();
        product.setProduct(productDto.getProduct());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCondition(productDto.getCondition());
        product.setActive(false);

        user.addProduct(product);
        category.addProduct(product);

        for (MultipartFile image : productDto.getImages()) {
            Images img = imagesServices.createImages(image);
            product.addImage(img);
        }

        productRepository.save(product);

        return productMappers.castProductData(product);
    }

    @Override
    public ResponseProductDto updateProduct(UpdateProductDto productDto) {

        Product productToUpdate = productRepository.findProductById(UUID.fromString(productDto.getId()));

        if(productToUpdate == null){
            throw new ProductNotFound();
        }

        productToUpdate.setPrice(productDto.getPrice());
        productRepository.save(productToUpdate);

        return productMappers.castProductData(productToUpdate);
    }

    @Override
    public String activateProduct(String id) {
        Product productToActive = productRepository.findProductById(UUID.fromString(id));

        if(productToActive == null){
            throw new ProductNotFound();
        }

        productToActive.setActive(true);
        productRepository.save(productToActive);

        return "Product activated";
    }

    @Override
    public List<ResponseProductDto> getProductsByActive(Boolean active) {
        List<Product> products = productRepository.findProductByActive(active);

        return  productMappers.getCastedProductList(products);
    }

    @Override
    public ResponseProductDto getProductById(String id) {
        Product product =  productRepository.findProductById(UUID.fromString(id));

        if(product == null){
            throw new ProductNotFound();
        }

        return productMappers.castProductData(product);
    }

    @Override
    public List<ResponseProductDto> getProductsByUserAndActive(String email, Boolean active) {
        User user = userRepository.findByUsername(email);
        List<Product> products = productRepository.findProductsByUserAndActive(user, active);

        return productMappers.getCastedProductList(products);
    }

    @Override
    public List<ResponseProductDto> getProductsByAuthUserAndActive(Boolean active) {
        User user = getUserSession();
        List<Product> products = productRepository.findProductsByUserAndActive(user, active);

        return productMappers.getCastedProductList(products);
    }

    @Override
    public List<ResponseProductDto> getProductsByCategoryAndActive(String categoryName, Boolean active) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        List<Product> products = productRepository.findProductsByCategoryAndActive(category, active);

        return productMappers.getCastedProductList(products);
    }

    @Override
    public void deleteProduct(String id) {
        Product productToDelete = productRepository.findProductById(UUID.fromString(id));

        if(productToDelete == null){
            throw new ProductNotFound();
        }

        productRepository.delete(productToDelete);
    }

    @Override
    public User getUserSession(){
        User userNoSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userNoSession.getUsername());
    }
}
