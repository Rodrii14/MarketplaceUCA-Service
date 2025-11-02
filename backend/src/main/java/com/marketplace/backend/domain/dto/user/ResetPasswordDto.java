package com.marketplace.backend.domain.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ResetPasswordDto {

    @JsonProperty("oldPassword")
    @NotNull
    @NotBlank
    private String oldPassword;

    @JsonProperty("newPassword")
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{8,}$")
    private String newPassword;
}
