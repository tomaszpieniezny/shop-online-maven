package com.shop.shoponline.model.dao;

import com.shop.shoponline.model.entity.DeliveryDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface DeliveryDetailDao extends CrudRepository<DeliveryDetail, Long> {

    @Override
    DeliveryDetail save(DeliveryDetail deliveryDetail);
}
