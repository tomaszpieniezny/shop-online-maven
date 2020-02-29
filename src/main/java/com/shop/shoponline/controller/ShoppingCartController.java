package com.shop.shoponline.controller;

import com.shop.shoponline.mapper.ShoppingCartMapper;
import com.shop.shoponline.model.dto.ShoppingCartDto;
import com.shop.shoponline.model.entity.ShoppingCart;
import com.shop.shoponline.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/shoppingCart")
    public List<ShoppingCartDto> getShoppingCart () {
        return shoppingCartMapper.mapToShoppingCartDtoList(shoppingCartService.findAllShoppingCart());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/shoppingCart/{id}")
    public ShoppingCartDto getShoppingCartById (@PathVariable int id) throws Exception{
        return shoppingCartMapper.mapToShoppingCartDto(shoppingCartService.getShoppingCart(id).orElseThrow(Exception::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/shoppingCart")
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart newShoppingCart) {
        return shoppingCartService.saveShoppingCart(newShoppingCart);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/shoppingCart")
    public ShoppingCart updateShoppingCart (@RequestBody ShoppingCart updateShoppingCart) {
        return shoppingCartService.saveShoppingCart(updateShoppingCart);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/shoppingCart/{id}")
    public void deleteShoppingCart (@PathVariable int id) {
        shoppingCartService.deleteShoppingCart(id);
    }
}
