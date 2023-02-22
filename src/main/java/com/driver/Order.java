package com.driver;

import javax.annotation.Generated;

public class Order {


    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {
        String   stringHours = String.valueOf(deliveryTime.charAt(0) + deliveryTime.charAt(1));
        int hours = Integer.parseInt(stringHours);
        hours=hours*60;
        String  stringMinutes = String.valueOf(deliveryTime.charAt(3)+deliveryTime.charAt(4));
        int minutes= Integer.parseInt(stringMinutes);
        int ans =hours+minutes;
        this.id = id ;
        this.deliveryTime = ans;
//HH:MM;
        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDeliveryTime(int ans) {
        this.deliveryTime = deliveryTime;
    }

    public int getDeliveryTime() {return deliveryTime;}
}