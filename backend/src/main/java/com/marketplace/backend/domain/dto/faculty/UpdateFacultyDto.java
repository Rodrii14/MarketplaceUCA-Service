package com.marketplace.backend.domain.dto.faculty;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateFacultyDto {

    @JsonProperty("facultyName")
    @NotNull
    @NotBlank
    private String facultyName;

    @JsonProperty("newFacultyName")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    private String newFacultyName;
}
