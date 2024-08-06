package com.example.after_sky_takeayay.service.impl;

import com.example.after_sky_takeayay.aop.XiaoGuo;
import com.example.after_sky_takeayay.pojo.bean.Category;
import com.example.after_sky_takeayay.pojo.bean.Dish;
import com.example.after_sky_takeayay.pojo.bean.User;
import com.example.after_sky_takeayay.mapper.UserMapper;
import com.example.after_sky_takeayay.service.UserService;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.LinkedList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @XiaoGuo
    @Override
    public int register( String name, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println("此时的信息为:"+name+"   "+password);
        return userMapper.register(0,name,password);
    }
    @XiaoGuo
    @Override
    public User ulogin(int id, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println("加密后的密码为:"+password);
        return userMapper.ulogin(id,password);
    }

    @Override
    public LinkedList<Category> getCategory() {
        return userMapper.getCategory();
    }

    @Override
    public LinkedList<Dish> getDish() {
        return userMapper.getDish();
    }
}