package com.shop.shoponline.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeliveryDetailDto {
    private int id;
    private String city;
    private String street;
    private String postcode;
    private String houseNumber;
}
