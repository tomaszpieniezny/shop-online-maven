package com.shop.shoponline.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
}