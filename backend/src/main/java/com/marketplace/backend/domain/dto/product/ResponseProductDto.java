package com.marketplace.backend.domain.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDto {

    private UUID id;
    private String product;
    private String description;
    private double price;
    private String condition;
    private List<String> images = new ArrayList<>();
    private Boolean active;
    private String categoryName;
    private String userName;
    private String phoneNumber;
}