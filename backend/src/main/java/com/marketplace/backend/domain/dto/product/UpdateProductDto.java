package com.marketplace.backend.domain.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateProductDto {

    @JsonProperty("id")
    @NotNull
    @NotBlank
    private String id;

    @JsonProperty("price")
    @NotNull
    @NotBlank
    private double price;
}