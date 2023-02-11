package com.driver;

import org.springframework.http.ResponseEntity;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();
    public String addOrder(Order order) {
      return  orderRepository.addOrder(order);
    }

    public String addPartner(String partnerId) {
       return orderRepository.addPartner(partnerId);

    }

    public String addOrderPartnerPair(String orderId, String partnerId) {
        return orderRepository.addOrderPartnerPair(orderId,partnerId);
    }


    public Order getOrderById(String orderId) {
        return orderRepository.getOrderById(orderId);
    }
}
