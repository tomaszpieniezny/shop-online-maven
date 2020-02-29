package com.shop.shoponline.controller;

import com.shop.shoponline.mapper.DeliveryDetailMapper;
import com.shop.shoponline.model.dto.DeliveryDetailDto;
import com.shop.shoponline.model.entity.DeliveryDetail;
import com.shop.shoponline.service.DeliveryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class DeliveryDetailController {
    @Autowired
    DeliveryDetailService deliveryDetailService;

    @Autowired
    DeliveryDetailMapper deliveryDetailMapper;


    @RequestMapping(method = RequestMethod.GET, value = "/deliveryDetail")
    public List<DeliveryDetail> getDeliveryDetail () {
        return deliveryDetailService.getAllDeliveryDetail();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deliveryDetail/{id}")
    public DeliveryDetailDto getDeliveryDetailById (@PathVariable int id) throws Exception {
        return deliveryDetailMapper.mapToDeliverDetail(deliveryDetailService.getDeliveryDetail(id).orElseThrow(Exception::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deliveryDetail", consumes = APPLICATION_JSON_VALUE)
    public DeliveryDetail creatDeliveryDetail(@RequestBody DeliveryDetail newDeliveryDetail) {
        return deliveryDetailService.save(newDeliveryDetail);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/deliveryDetail", consumes = APPLICATION_JSON_VALUE)
    public DeliveryDetail updateDeliveryDetail(@RequestBody DeliveryDetail newDeliveryDetail) {
        return deliveryDetailService.save(newDeliveryDetail);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deliveryDetail/{id}")
    public void deleteDeliveryDetail(@PathVariable int id) {
        deliveryDetailService.deleteDeliveryDetail(id);
    }


}
