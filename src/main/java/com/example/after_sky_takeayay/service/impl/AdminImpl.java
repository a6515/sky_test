package com.example.after_sky_takeayay.service.impl;

import com.example.after_sky_takeayay.mapper.AdminMapper;
import com.example.after_sky_takeayay.pojo.bean.Dish;
import com.example.after_sky_takeayay.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class AdminImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public LinkedList<Dish> dish(int limit, int current) {
        return adminMapper.dish(limit,(current-1)*limit);
    }

    @Override
    public int dish_count() {
        return adminMapper.dish_count();
    }

}
