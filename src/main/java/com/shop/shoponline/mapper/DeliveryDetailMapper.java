package com.shop.shoponline.mapper;

import com.shop.shoponline.model.dto.DeliveryDetailDto;
import com.shop.shoponline.model.dto.UserAccountDto;
import com.shop.shoponline.model.entity.DeliveryDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeliveryDetailMapper {

    public DeliveryDetail mapToDeliverDetailDto (DeliveryDetailDto deliveryDetailDto) {
        return new DeliveryDetail(
                deliveryDetailDto.getId(),
                deliveryDetailDto.getCity(),
                deliveryDetailDto.getStreet(),
                deliveryDetailDto.getPostcode(),
                deliveryDetailDto.getHouseNumber());
    }

    public DeliveryDetailDto mapToDeliverDetail (DeliveryDetail deliveryDetail) {
        return new DeliveryDetailDto(
                deliveryDetail.getId(),
                deliveryDetail.getCity(),
                deliveryDetail.getStreet(),
                deliveryDetail.getPostcode(),
                deliveryDetail.getHouseNumber());
    }

    public List<DeliveryDetailDto> mapToDeliverDetailList (List<DeliveryDetail> deliveryDetail) {
        return deliveryDetail.stream()
                .map(deliveryDetail1 -> new DeliveryDetailDto(
                        deliveryDetail1.getId(),
                        deliveryDetail1.getCity(),
                        deliveryDetail1.getStreet(),
                        deliveryDetail1.getPostcode(),
                        deliveryDetail1.getHouseNumber()))
                .collect(Collectors.toList());
    }
}
