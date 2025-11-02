package com.marketplace.backend.domain.dto.faculty;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateFacultyDto {

    @JsonProperty("facultyName")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    private String facultyName;
}

