package com.driver;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderRepository {
    HashMap<String ,Order> orderMap= new HashMap<>();
    HashMap<String,Integer>partnerMap = new HashMap<>();
    HashMap<String , List<String>>orderpartnerRelMap = new HashMap<>();
    public String addOrder(Order order) {
        orderMap.put(order.getId(),order);
        return "Successfully added";
    }

    public String addPartner(String partnerId) {
        partnerMap.put(partnerId,partnerMap.getOrDefault(partnerId,0)+1);
        return "done";

    }

    public String addOrderPartnerPair(String orderId, String partnerId) {
       ArrayList<String > partnerlist= (ArrayList<String>) orderpartnerRelMap.getOrDefault(orderId,new ArrayList<>());
       partnerlist.add(partnerId);
       orderpartnerRelMap.put(orderId,partnerlist);
        return "done";
    }

    public Order getOrderById(String orderId) {

            return orderMap.get(orderId);

    }
}
