package com.shop.shoponline.service;

import com.shop.shoponline.model.dao.ShoppingCartDao;
import com.shop.shoponline.model.dao.UserDao;
import com.shop.shoponline.model.entity.ShoppingCart;
import com.shop.shoponline.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    public List<ShoppingCart> findAllShoppingCart () {
        return shoppingCartDao.findAll();
    }
    public Optional<ShoppingCart> getShoppingCart (final int id) {
        return shoppingCartDao.findById(id);
    }

    public ShoppingCart saveShoppingCart (final ShoppingCart shoppingCart){
        return shoppingCartDao.save(shoppingCart);
    }

    public void deleteShoppingCart (final int id) {
        shoppingCartDao.deleteById(id);
    }
}
