package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {

    HashMap<String,Order> orderMap= new HashMap<>();
    HashMap<String,DeliveryPartner>partnerMap = new HashMap<>();
    HashMap<String ,DeliveryPartner> OrderdeliveryMap= new HashMap<>();
    HashMap<String,List<Order>> partnerOrdersMap = new HashMap<>();
    public String addOrder(Order order) {
orderMap.put((order.getId()),order);
return "done";
    }

    public String addPartner(String partnerId) {
        DeliveryPartner deliveryPartner =new DeliveryPartner(partnerId);

        partnerMap.put(partnerId,deliveryPartner);
        return "Done";
    }

    public String addOrderPartnerPair(String orderId, String partnerId) {
          DeliveryPartner deliveryPartner=partnerMap.get(partnerId);
         int order = deliveryPartner.getNumberOfOrders();
         order =order+1;
        deliveryPartner.setNumberOfOrders(order);
         OrderdeliveryMap.put(orderId,deliveryPartner);

         List<Order>list = new ArrayList<>();
         list.add(orderMap.get(order));
         partnerOrdersMap.put(partnerId,list);


        return "successfully done";


    }

    public Order getOrderById(String orderId) {
      return  orderMap.get(orderId);

    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return partnerMap.get(partnerId);
    }


    public Integer getOrderCountByPartnerId(String partnerId) {
        int order=0;
        for(DeliveryPartner deliveryPartner : OrderdeliveryMap.values()){
            if(deliveryPartner.getId().equals(partnerId)){
                order = deliveryPartner.getNumberOfOrders();
            }
        }
        return order;
    }

    public List<Order> getOrdersByPartnerId(String partnerId) {

  return  partnerOrdersMap.get(partnerId);

    }

    public List<String> getAllOrders() {
        List<String>list = new ArrayList<>();
        for(String s:orderMap.keySet())
        {
            list.add(s);
        }
        return list;
    }

    public Integer getCountOfUnassignedOrders() {
        int countNoOrders =0;
        int assignedOrder=0;
        for(Order order:orderMap.values()){
            countNoOrders++;
        }
        for(String s: OrderdeliveryMap.keySet()){
            assignedOrder++;
        }
        return countNoOrders-assignedOrder;
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {

        String   stringHours = String.valueOf(time.charAt(0) + time.charAt(1));
        int hours = Integer.parseInt(stringHours);
        hours=hours*60;
        String  stringMinutes = String.valueOf(time.charAt(3)+time.charAt(4));
        int minutes= Integer.parseInt(stringMinutes);
        int ans =hours+minutes;
        int count=0;
        for(List<Order>orders : partnerOrdersMap.values()){
            for(Order order: orders){
                if(order.getDeliveryTime()< ans){
                    count++;
                }
            }
        }
        return count;
    }

    public String deletePartnerById(String partnerId) {
  //  DeliveryPartner partner=    partnerMap.get(partnerId);
//    int id =
//
//        for(DeliveryPartner deliveryPartner : OrderdeliveryMap.values()){
//            if(deliveryPartner.equals(partner){
//
//                OrderdeliveryMap.remove();
//            }
//        }
        partnerMap.remove(partnerId);
        partnerOrdersMap.remove(partnerId);
        return "done";
    }

    public String deleteOrderById(String orderId) {
        orderMap.remove(orderId);
      DeliveryPartner partner=  OrderdeliveryMap.get(orderId);
      partnerMap.remove(partner.getId());
      OrderdeliveryMap.remove(orderId);
      return "Success";

    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        return "1";
    }
}
