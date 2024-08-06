package com.example.after_sky_takeayay.pojo.bean;

public class Cart {
    private int id;
    private int dish_id;
    private String dish_name;
    private int number;
    private float unit_price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }
    /* */
    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", dish_id=" + dish_id +
                ", dish_name='" + dish_name + '\'' +
                ", number=" + number +
                ", unit_price=" + unit_price +
                '}';
    }

}
