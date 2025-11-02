package com.marketplace.backend.domain.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UpdateCategoryDto {

    @JsonProperty("name")
    private String name;
    @JsonProperty("newName")
    private String newName;
    @JsonProperty("newDescription")
    @Size(max = 250)
    private String newDescription;
}
