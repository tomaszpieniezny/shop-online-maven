package com.shop.shoponline.model.dao;

import com.shop.shoponline.model.entity.ShoppingCart;
import com.shop.shoponline.model.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ShoppingCartDao extends CrudRepository <ShoppingCart, Long> {

    @Override
    ShoppingCart save(ShoppingCart shoppingCart);

    List<ShoppingCart> findAll();

    Optional<ShoppingCart> findById(int id);

    void deleteById(final int id);
}
