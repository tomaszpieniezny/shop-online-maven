package com.shop.shoponline.mapper;

import com.shop.shoponline.model.dto.OrdersDto;
import com.shop.shoponline.model.entity.Orders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdersMapper {

    public Orders orders(OrdersDto ordersDto) {
        return new Orders(
                ordersDto.getId(),
                ordersDto.getDateOfPayment(),
                ordersDto.getDateOfPayment(),
                ordersDto.getStatus());
    }
    public OrdersDto mapToOrdersDto(Orders orders) {
        return new OrdersDto(
                orders.getId(),
                orders.getDateOfOrder(),
                orders.getDateOfPayment(),
                orders.getStatus());
    }
    public List<OrdersDto> mapToOrdersDtoList(List<Orders> ordersList) {
        return ordersList.stream()
                .map(orders -> new OrdersDto(
                        orders.getId(),
                        orders.getDateOfOrder(),
                        orders.getDateOfPayment(),
                        orders.getStatus()))
                .collect(Collectors.toList());
    }
}
