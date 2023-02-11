package com.driver;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrderService {
    static OrderRepository orderRepository = new OrderRepository();

    public static Integer getOrderCountByPartnerId(String partnerId) {
        return orderRepository.getOrderCountByPartnerId(partnerId);
    }

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

    public DeliveryPartner getPartnerById(String partnerId) {
        return orderRepository.getPartnerById(partnerId);
    }


    public List<String> getOrdersByPartnerId(String partnerId) {
    return     orderRepository.getOrdersByPartnerId(partnerId);
    }

    public List<String> getAllOrders() {
     return   orderRepository.getAllOrders();
    }

    public Integer getCountOfUnassignedOrders() {
        return orderRepository.getCountOfUnassignedOrders();
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
        return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(time,partnerId);
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
       return orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
    }

    public String deletePartnerById(String partnerId) {
       return  orderRepository.deletePartnerById(partnerId);
    }

    public String deleteOrderById(String orderId) {
       return orderRepository.deleteOrderById(orderId);
    }
}
