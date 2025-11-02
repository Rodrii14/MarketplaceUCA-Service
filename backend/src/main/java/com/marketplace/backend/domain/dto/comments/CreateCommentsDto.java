package com.marketplace.backend.domain.dto.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentsDto {

    @JsonProperty("productId")
    @NotNull
    @NotBlank
    private String productId;

    @JsonProperty("comment")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 250)
    private String comment;

}
