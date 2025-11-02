package com.marketplace.backend.controllers;

import com.marketplace.backend.domain.dto.GeneralResponse;
import com.marketplace.backend.domain.dto.product.CreateProductDto;
import com.marketplace.backend.domain.dto.product.ResponseProductDto;
import com.marketplace.backend.domain.dto.product.UpdateProductDto;
import com.marketplace.backend.services.iProductServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {

    private final iProductServices productServices;

    @PostMapping("product/create")
    public ResponseEntity<GeneralResponse> createProduct(
            @RequestPart("product") @Valid CreateProductDto createProductDto,
            @RequestPart("images") List<MultipartFile> images
    ) {
        createProductDto.setImages(images);
        ResponseProductDto product = productServices.createProduct(createProductDto);

        return GeneralResponse.builder()
                .data(product)
                .message("Product created successfully")
                .status(HttpStatus.CREATED)
                .build();
    }

    @PatchMapping("product/update")
    public ResponseEntity<GeneralResponse> updateProduct(@RequestBody UpdateProductDto updateProductDto) {
        ResponseProductDto responseData = productServices.updateProduct(updateProductDto);

        return GeneralResponse.builder()
                .data(responseData)
                .message("Product updated successfully")
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("admin/product/activation/{id}")
    public ResponseEntity<GeneralResponse> activateProduct(@PathVariable String id) {
        String resp = productServices.activateProduct(id);

        return GeneralResponse.builder()
                .data(resp)
                .message("Ok")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("product/")
    public ResponseEntity<GeneralResponse> getAllProducts() {
        List<ResponseProductDto> responseData = productServices.getProductsByActive(true);

        return GeneralResponse.builder()
                .data(responseData)
                .message("OK")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("admin/product/")
    public ResponseEntity<GeneralResponse> getAllInactiveProducts() {
        List<ResponseProductDto> responseData = productServices.getProductsByActive(false);

        return GeneralResponse.builder()
                .data(responseData)
                .message("OK")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("product/{id}")
    public ResponseEntity<GeneralResponse> getProductById(@PathVariable String id) {
        ResponseProductDto responseData = productServices.getProductById(id);

        return GeneralResponse.builder()
                .data(responseData)
                .message("Ok")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("product/user")
    public ResponseEntity<GeneralResponse> getProductByUser(@RequestParam(name = "email") String email) {
        List<ResponseProductDto> responseData = productServices.getProductsByUserAndActive(email, true);

        return GeneralResponse.builder()
                .data(responseData)
                .message("Ok")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("product/my")
    public ResponseEntity<GeneralResponse> getProductByAuthUser() {
        List<ResponseProductDto> responseData = productServices.getProductsByAuthUserAndActive(true);

        return GeneralResponse.builder()
                .data(responseData)
                .message("Ok")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("product/category/{name}")
    public ResponseEntity<GeneralResponse> getProductByCategory(@PathVariable String name) {
        List<ResponseProductDto> responseData = productServices.getProductsByCategoryAndActive(name, true);

        return GeneralResponse.builder()
                .data(responseData)
                .message("Ok")
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<GeneralResponse> deleteProductByCode(@PathVariable String id) {
        productServices.deleteProduct(id);

        return GeneralResponse.builder()
                .message("Product deleted successfully")
                .status(HttpStatus.OK)
                .build();
    }
}