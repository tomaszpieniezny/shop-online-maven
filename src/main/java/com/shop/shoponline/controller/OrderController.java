package com.shop.shoponline.controller;

import com.shop.shoponline.mapper.OrdersMapper;
import com.shop.shoponline.model.dto.OrdersDto;
import com.shop.shoponline.model.entity.Orders;
import com.shop.shoponline.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class OrderController {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public List<OrdersDto> getOrder() {
        return ordersMapper.mapToOrdersDtoList(orderService.findAllOrders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders/{id}")
    public OrdersDto getOrderById(@PathVariable int id) throws Exception {
        return ordersMapper.mapToOrdersDto(orderService.getOrders(id).orElseThrow(Exception::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders", consumes = APPLICATION_JSON_VALUE)
    public Orders createOrder(@RequestBody Orders newOrders) {
        return orderService.saveOrders(newOrders);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders", consumes = APPLICATION_JSON_VALUE)
    public Orders updateOrder(@RequestBody Orders updateOrders) {
        return orderService.saveOrders(updateOrders);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrders(id);
    }
}
