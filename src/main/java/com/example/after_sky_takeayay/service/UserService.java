package com.example.after_sky_takeayay.service;

import com.example.after_sky_takeayay.pojo.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.LinkedList;

public interface UserService {
    public User ulogin(int id,  String password);
    public int register(String name, String password);
    public LinkedList<Category> getCategory();

    public LinkedList<Dish> getDish();
    public int addCart(int dish_id ,String dish_name,float price);
    public Cart findById_Cart( int id,  int dish_id);
    public int addCart_exact( int id,int dish_id);
    public LinkedList<Cart> getCart();

    public int sub_item(int dish_id);

    public int add_item(int dish_id);

    public int remove_item( int dish_id);
    public int pay(LinkedList<Cart> cart);
    public int order_detial(OrderDetials orderDetials);
    public int cart_remove(int id);
}
