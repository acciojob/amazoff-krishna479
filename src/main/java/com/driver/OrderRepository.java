package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {

    HashMap<String,Order> orderMap= new HashMap<>();
    HashMap<String,DeliveryPartner>partnerMap = new HashMap<>();
    HashMap<String ,String> orderPartnerPair= new HashMap<>();//
    HashMap<String,List<String>> partnerOrdersMap = new HashMap<>();
        public void addOrder(Order order) {
        orderMap.put(order.getId(),order);

        }

    public void addPartner(String partnerId) {
            partnerMap.put(partnerId,new DeliveryPartner(partnerId));


    }

    public void addOrderPartnerPair(String orderId, String partnerId) {


         List<String>list = partnerOrdersMap.getOrDefault(partnerId,new ArrayList<>());
         list.add(orderId);
         partnerOrdersMap.put(partnerId,list);

         orderPartnerPair.put(orderId,partnerId);
         // update the list

    DeliveryPartner deliveryPartner = partnerMap.get(partnerId);
    deliveryPartner.setNumberOfOrders(list.size());





    }

    public Order getOrderById(String orderId) {
      return  orderMap.get(orderId);

    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return partnerMap.get(partnerId);
    }


    public Integer getOrderCountByPartnerId(String partnerId) {
        int order=0;
      DeliveryPartner deliveryPartner=  partnerMap.get(partnerId);
      order =deliveryPartner.getNumberOfOrders();


        return order;
    }

    public List<String> getOrdersByPartnerId(String partnerId) {

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

return orderMap.size()-partnerOrdersMap.size();

    }


    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {


        int countOrdersLeft=0;
        int time1 = Order.getTimeAsInt(time);

        List<String>ordersId = partnerOrdersMap.get(partnerId);

            for(String s: ordersId){
                if(orderMap.get(s).getDeliveryTime() > time1){
                    countOrdersLeft++;
                }
            }
        return countOrdersLeft;
        }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
int lastDeliveryTime = 0;

List<String>ordersId = partnerOrdersMap.get(partnerId);

for(String s : ordersId){

    lastDeliveryTime = Math.max(lastDeliveryTime,orderMap.get(ordersId).getDeliveryTime());

}
return Order.getTimeAsString(lastDeliveryTime);
        }

    public void deletePartnerById(String partnerId) {
            List<String>ordersIds = partnerOrdersMap.get(partnerId);

            for(String ordersId : ordersIds){
              orderPartnerPair.remove(ordersId);
            }

        partnerMap.remove(partnerId);
        partnerOrdersMap.remove(partnerId);

    }


    public void deleteOrderById(String orderId) {
            orderMap.remove(orderId);
            if(orderPartnerPair.containsKey(orderId)) {
                String partnerId = orderPartnerPair.get(orderId);
                orderPartnerPair.remove(orderId);


                partnerOrdersMap.get(partnerId).remove(orderId);

            partnerMap.get(partnerId).setNumberOfOrders(partnerOrdersMap.get(partnerId).size());
            }


    }


}
