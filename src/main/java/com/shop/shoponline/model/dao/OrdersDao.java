package com.shop.shoponline.model.dao;

import com.shop.shoponline.model.entity.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OrdersDao extends CrudRepository<Orders, Long> {

    List<Orders> findAll();

    Optional<Orders> findById(int id);

    void deleteById(int id);

    @Override
    Orders save(Orders order);
}
