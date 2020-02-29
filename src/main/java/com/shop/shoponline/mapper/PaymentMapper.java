package com.shop.shoponline.mapper;

import com.shop.shoponline.model.dto.PaymentDto;
import com.shop.shoponline.model.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMapper {

    public PaymentDto mapToPaymentDto (Payment payment) {
        return new PaymentDto(
                payment.getId(),
                payment.getMethod(),
                payment.getStatus());
    }

    public Payment mapToPayment (PaymentDto paymentDto) {
        return new Payment(
                paymentDto.getId(),
                paymentDto.getMethod(),
                paymentDto.getStatus());
    }

    public List<PaymentDto> mapToPaymentDtoList (List<Payment> paymentslist) {
        return paymentslist.stream()
                .map(payment -> new PaymentDto(payment.getId(),
                        payment.getMethod(),
                        payment.getStatus()))
                .collect(Collectors.toList());
    }
}
