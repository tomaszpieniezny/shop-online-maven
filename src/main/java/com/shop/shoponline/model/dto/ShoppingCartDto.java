package com.shop.shoponline.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
public class ShoppingCartDto {
    private int id;
    private long quantity;
}
