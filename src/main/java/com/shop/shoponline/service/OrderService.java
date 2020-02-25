package com.shop.shoponline.service;

import com.shop.shoponline.model.dao.OrdersDao;
import com.shop.shoponline.model.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrdersDao orderDao;

    public Orders saveOrders(final Orders orderDetail) {
        return orderDao.save(orderDetail);
    }

    public List<Orders> findAllOrders() {
        return orderDao.findAll();
    }

    public Optional<Orders> getOrders(final int id) {
        return orderDao.findById(id);
    }

    public void deleteOrders(final int id) {
        orderDao.deleteById(id);
    }
}
