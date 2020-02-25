package com.shop.shoponline.model.dto;

import com.shop.shoponline.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private User.enumUserStatus status;

}
