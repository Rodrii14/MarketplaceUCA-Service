package com.marketplace.backend.domain.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateUserDto {

    @JsonProperty("phoneNumber")
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[267]\\d{7}$")
    private String phoneNumber;
}
