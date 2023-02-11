package com.driver;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderRepository {
    HashMap<String ,Order> orderMap= new HashMap<>();
    HashMap<String,DeliveryPartner>partnerMap = new HashMap<>();
    HashMap<String , ArrayList<String>>orderpartnerRelMap = new HashMap<>();
    public String addOrder(Order order) {
        orderMap.put(order.getId(),order);
        return "Successfully added";
    }

    public String addPartner(String partnerId) {
        DeliveryPartner deliverypartner= new DeliveryPartner(partnerId);


        partnerMap.put(partnerId,deliverypartner);
        return "done";

    }

    public String addOrderPartnerPair(String orderId, String partnerId) {
       ArrayList<String > orderlist=  orderpartnerRelMap.getOrDefault(partnerId,new ArrayList<>());
       orderlist.add(partnerId);
       orderpartnerRelMap.put(partnerId,orderlist);
        return "done";
    }

    public Order getOrderById(String orderId) {

            return orderMap.get(orderId);

    }


    public DeliveryPartner getPartnerById(String partnerId) {
       return partnerMap.get(partnerId);
    }

    public Integer getOrderCountByPartnerId(String partnerId) {
        List<String>list =  orderpartnerRelMap.get(partnerId);
        return list.size();
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
       return orderpartnerRelMap.get(partnerId);

    }

    public List<String> getAllOrders() {
        ArrayList<String>orders = new ArrayList<>();
        for(String s:orderMap.keySet()){
            orders.add(s);
        }
        return orders;


    }

    public Integer getCountOfUnassignedOrders() {
        int temp =0;
        int temp2=0;
        for(ArrayList<String > s: orderpartnerRelMap.values()){
         temp+=s.size();
        }
        for(String s:orderMap.keySet()){
            temp2++;
        }
        return temp-temp2;
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
        return 0;
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        return "0";
    }

    public void deletePartnerById(String partnerId) {

    }

    public void deleteOrderById(String orderId) {
        orderMap.remove(orderId);

    }
}
