package com.marketplace.backend.domain.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccessUserDto {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}
