package com.shop.shoponline.model.dto;

import com.shop.shoponline.model.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class OrdersDto {
    private int id;
    private LocalDate dateOfOrder;
    private LocalDate dateOfPayment;
    private Orders.enumOrderStatus status;
}

