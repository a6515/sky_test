package com.example.after_sky_takeayay.pojo.bean;

import java.util.Date;

public class OrderDetials {
    private int orderDetial_id;
    private int order_id;
    private int dish_id;
    private String dish_name;
    private int number;
    private float price;
    private Date time;

    public OrderDetials(int orderDetial_id, int order_id, int dish_id, String dish_name, int number, float price, Date time) {
        this.orderDetial_id = orderDetial_id;
        this.order_id = order_id;
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.number = number;
        this.price = price;
        this.time = time;
    }

    public int getOrderDetial_id() {
        return orderDetial_id;
    }

    public void setOrderDetial_id(int orderDetial_id) {
        this.orderDetial_id = orderDetial_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
