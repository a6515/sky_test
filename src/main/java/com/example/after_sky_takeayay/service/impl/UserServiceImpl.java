package com.example.after_sky_takeayay.service.impl;

import com.example.after_sky_takeayay.aop.XiaoGuo;
import com.example.after_sky_takeayay.pojo.bean.*;
import com.example.after_sky_takeayay.mapper.UserMapper;
import com.example.after_sky_takeayay.service.UserService;
import com.example.after_sky_takeayay.utils.JwtUtils;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    HttpServletRequest request;

    @XiaoGuo
    @Override
    public int register(String name, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println("此时的信息为:" + name + "   " + password);
        return userMapper.register(0, name, password);
    }

    @XiaoGuo
    @Override
    public User ulogin(int id, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println("加密后的密码为:" + password);
        return userMapper.ulogin(id, password);
    }

    @Override
    public LinkedList<Category> getCategory() {
        return userMapper.getCategory();
    }

    @Override
    public Cart findById_Cart(int id, int dish_id) {
        return userMapper.findById_Cart(id, dish_id);
    }

    @Override
    public LinkedList<Dish> getDish() {
        return userMapper.getDish();
    }

    @Override
    public int addCart_exact(int id, int dish_id) {
        return userMapper.addCart_exact(id, dish_id);
    }

    @Override
    public int addCart(int dish_id, String dish_name, float price) {
        Map<String, Object> claims = JwtUtils.parseToken(request.getHeader("Authorization"));
        int id = Integer.parseInt((String) claims.get("id"));
        System.out.println("得到的ID为:" + id);
        Cart cart = findById_Cart(id, dish_id);
        if (cart == null) {
            return userMapper.addCart(id, dish_id, dish_name, 1, price);
        } else return addCart_exact(id, dish_id);

    }

    @Override
    public LinkedList<Cart> getCart() {
        Map<String, Object> claims = JwtUtils.parseToken(request.getHeader("Authorization"));
        int id = Integer.parseInt((String) claims.get("id"));
        return userMapper.getCart(id);
    }

    @Override
    public int sub_item(int dish_id) {
        Map<String, Object> claims = JwtUtils.parseToken(request.getHeader("Authorization"));
        int id = Integer.parseInt((String) claims.get("id"));
        return userMapper.sub_item(id, dish_id);
    }

    @Override
    public int add_item(int dish_id) {
        Map<String, Object> claims = JwtUtils.parseToken(request.getHeader("Authorization"));
        int id = Integer.parseInt((String) claims.get("id"));
        return userMapper.add_item(id, dish_id);
    }

    @Override
    public int remove_item(int dish_id) {
        Map<String, Object> claims = JwtUtils.parseToken(request.getHeader("Authorization"));
        int id = Integer.parseInt((String) claims.get("id"));
        return userMapper.remove_item(id, dish_id);
    }

    @Override
    public int order_detial(OrderDetials orderDetials) {
        return userMapper.order_detial(orderDetials);
    }

    @Override
    public int cart_remove(int id) {
        return userMapper.cart_remove(id);
    }

    @Override
    public int pay(LinkedList<Cart> cart) {
        Map<String, Object> claims = JwtUtils.parseToken(request.getHeader("Authorization"));
        int id = Integer.parseInt((String) claims.get("id"));
        float sum_price = 0;
        for (Cart item : cart) {
            sum_price += item.getUnit_price() * (item.getNumber());
        }
        Orders orders = new Orders();
        orders.setId(id);
        orders.setSum_price(sum_price);
        int n = userMapper.pay(orders);
        System.out.println("得到的自增长ID为:" + orders.getOrder_id());
        for (Cart item : cart) {
            order_detial(new OrderDetials(0, orders.getOrder_id(), item.getDish_id(), item.getDish_name(),item.getNumber() ,item.getUnit_price(), null));
        }
        if (n > 0) {
            cart_remove(id);
            return n;
        } else return 0;

    }
}