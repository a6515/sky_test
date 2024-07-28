package com.example.after_sky_takeayay.controller;

import com.example.after_sky_takeayay.pojo.bean.Dish;
import com.example.after_sky_takeayay.pojo.dto.Result;
import com.example.after_sky_takeayay.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("dish_count")
    public Result<Integer> dish_count(){
        return Result.success(adminService.dish_count());
    }
    @RequestMapping("dish")
    public Result<LinkedList<Dish> > dish(@RequestParam String limit,@RequestParam String current){
        return Result.success(adminService.dish(Integer.parseInt(limit),Integer.parseInt(current)));
    }
}
