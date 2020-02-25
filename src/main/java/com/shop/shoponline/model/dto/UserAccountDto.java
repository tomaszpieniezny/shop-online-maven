package com.shop.shoponline.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAccountDto {
    private int id;
    private String login;
    private String password;
}
