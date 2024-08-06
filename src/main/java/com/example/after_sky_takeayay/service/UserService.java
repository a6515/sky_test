package com.example.after_sky_takeayay.service;

import com.example.after_sky_takeayay.pojo.bean.Category;
import com.example.after_sky_takeayay.pojo.bean.Dish;
import com.example.after_sky_takeayay.pojo.bean.OperateLog;
import com.example.after_sky_takeayay.pojo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;

public interface UserService {
    public User ulogin(int id,  String password);
    public int register(String name, String password);
    public LinkedList<Category> getCategory();

    public LinkedList<Dish> getDish();
}
