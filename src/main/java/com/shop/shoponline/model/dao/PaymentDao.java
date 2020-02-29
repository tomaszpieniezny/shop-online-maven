package com.shop.shoponline.model.dao;

import com.shop.shoponline.model.entity.Orders;
import com.shop.shoponline.model.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PaymentDao extends CrudRepository<Payment, Long> {


    List<Payment> findAll();

    Optional<Payment> findById(int id);

    void deleteById(int id);

    @Override
    Payment save(Payment payment);
}
