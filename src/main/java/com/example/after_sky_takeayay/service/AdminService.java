package com.example.after_sky_takeayay.service;

import com.example.after_sky_takeayay.pojo.bean.Dish;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;

public interface AdminService {
    public int dish_count();
    public LinkedList<Dish> dish( int limit, int current);
}
