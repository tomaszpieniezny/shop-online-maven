package com.shop.shoponline.model.dto;

import com.shop.shoponline.model.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentDto {
    private int id;
    private Payment.enumMethod method;
    private Payment.enumStatus status;
}
