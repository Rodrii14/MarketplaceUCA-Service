package com.marketplace.backend.domain.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateProductDto {

    @JsonProperty("product")
    @NotNull
    @NotBlank
    private String product;

    @JsonProperty("description")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    private String description;

    @JsonProperty("price")
    @NotNull
    @Positive
    private double price;

    @JsonProperty("condition")
    @NotNull
    @NotBlank
    private String condition;

    @JsonProperty("categoryName")
    @NotNull
    @NotBlank
    private String categoryName;

    private List<MultipartFile> images;

    private Boolean active;
}
