package com.example.after_sky_takeayay.controller;

import com.example.after_sky_takeayay.aop.XiaoGuo;
import com.example.after_sky_takeayay.pojo.dto.Result;
import com.example.after_sky_takeayay.pojo.bean.User;
import com.example.after_sky_takeayay.service.UserService;
import com.example.after_sky_takeayay.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/ulogin")
    public Result ulogin(@RequestParam String id, @RequestParam String password) {
        System.out.println("id和密码为:" + id + "  " + password);
        User user = userService.ulogin(Integer.parseInt(id), password);
        if (user == null) return Result.error("登陆失败");
        else {
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",id);
            String token=JwtUtils.genToken(claims);
            System.out.println("生成的Token为:"+token);
            return Result.success(token);
        }

    }

    @RequestMapping("/register")
    public Result register(@RequestParam String name,@RequestParam String password){
        int n = userService.register(name,password);
        if(n>0) return Result.success("新员工注册成功");
        else return Result.error("失败了");

    }


}
