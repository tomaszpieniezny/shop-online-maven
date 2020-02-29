package com.shop.shoponline.mapper;

import com.shop.shoponline.model.dao.ShoppingCartDao;
import com.shop.shoponline.model.dto.ShoppingCartDto;
import com.shop.shoponline.model.entity.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {
    public ShoppingCart mapToShoppingCart (ShoppingCartDto shoppingCartDto) {
        return new ShoppingCart(shoppingCartDto.getId(),
                shoppingCartDto.getQuantity());
    }

    public ShoppingCartDto mapToShoppingCartDto (ShoppingCart shoppingCart) {
        return new ShoppingCartDto(shoppingCart.getId(),
                shoppingCart.getQuantity());
    }

    public List<ShoppingCartDto> mapToShoppingCartDtoList (List<ShoppingCart> shoppingCarts) {
        return shoppingCarts.stream()
                .map(shoppingCart -> new ShoppingCartDto(shoppingCart.getId(),
                        shoppingCart.getQuantity()))
                .collect(Collectors.toList());
    }
}
