package com.shop.shoponline.controller;

import com.shop.shoponline.mapper.PaymentMapper;
import com.shop.shoponline.model.dto.PaymentDto;
import com.shop.shoponline.model.entity.Payment;
import com.shop.shoponline.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentMapper paymentMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/payment")
    public List<PaymentDto> getPayment () {
        return paymentMapper.mapToPaymentDtoList(paymentService.findAllPayment());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/payment/{id}")
    public PaymentDto getPaymentById (@PathVariable int id) throws Exception{
        return paymentMapper.mapToPaymentDto(paymentService.getPayment(id).orElseThrow(Exception::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/payment", consumes = APPLICATION_JSON_VALUE)
    public Payment createPayment (@RequestBody Payment newPayment) {
        return paymentService.savePayment(newPayment);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/payment", consumes = APPLICATION_JSON_VALUE)
    public Payment updatePayment (@RequestBody Payment newPayment) {
        return paymentService.savePayment(newPayment);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/payment/{id}")
    public void deletePayment (@PathVariable int id) {
        paymentService.deletePayment(id);
    }
}
