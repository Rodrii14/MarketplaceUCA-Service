package com.marketplace.backend.domain.dto.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCategoryDto {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String description;
}
