package com.shop.shoponline.service;

import com.shop.shoponline.model.dao.PaymentDao;
import com.shop.shoponline.model.entity.Orders;
import com.shop.shoponline.model.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public Payment savePayment(final Payment payment) {
        return paymentDao.save(payment);
    }

    public List<Payment> findAllPayment() {
        return paymentDao.findAll();
    }

    public Optional<Payment> getPayment(final int id) {
        return paymentDao.findById(id);
    }

    public void deletePayment(final int id) {
        paymentDao.deleteById(id);
    }
}

