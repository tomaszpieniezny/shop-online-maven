package com.shop.shoponline.service;

import com.shop.shoponline.model.dao.DeliveryDetailDao;
import com.shop.shoponline.model.entity.DeliveryDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryDetailService {

    @Autowired
    DeliveryDetailDao deliveryDetailDao;

    public DeliveryDetail save(DeliveryDetail deliveryDetail) {
        return deliveryDetailDao.save(deliveryDetail);
    }

    public Optional<DeliveryDetail> getDeliveryDetail(final int id) {
        return deliveryDetailDao.findById(id);
    }

    public void deleteDeliveryDetail(final int id) {
        deliveryDetailDao.deleteById(id);
    }

    public List<DeliveryDetail> getAllDeliveryDetail() {
        return deliveryDetailDao.findAll();
    }
}
