package com.example.after_sky_takeayay.controller;

import com.example.after_sky_takeayay.aop.XiaoGuo;
import com.example.after_sky_takeayay.pojo.bean.*;
import com.example.after_sky_takeayay.pojo.dto.Result;
import com.example.after_sky_takeayay.service.UserService;
import com.example.after_sky_takeayay.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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
        User user = new User(name,password);
        int n = userService.register(user);
        if(n>0) return Result.success(user.getId());
        else return Result.error("失败了");

    }
    @RequestMapping("/getDish")
    public Result<LinkedList<Dish> > getDish(){
        return Result.success(userService.getDish());
    }
    @RequestMapping("/getCategory")
    public Result<LinkedList<Category> > getCategory(){
        return Result.success(userService.getCategory());
    }
    @RequestMapping("/addCart")
    public Result addCart(@RequestParam String id,@RequestParam String name,@RequestParam String price){
        userService.addCart(Integer.parseInt(id),name,Float.parseFloat(price));
        return Result.success();
    }
    @RequestMapping("/getCart")
    public Result<LinkedList<Cart> > getCart(){
        return Result.success(userService.getCart());
    }
    @RequestMapping("/sub_item")
    public Result sub_item(@RequestParam String dish_id){
        userService.sub_item(Integer.parseInt(dish_id));
        return Result.success();
    }
    @RequestMapping("/add_item")
    public Result add_item(@RequestParam String dish_id){
        userService.add_item(Integer.parseInt(dish_id));
        return Result.success();
    }
    @RequestMapping("/remove_item")
    public Result remove_item(@RequestParam String dish_id){
        userService.remove_item(Integer.parseInt(dish_id));
        return Result.success();
    }
    @RequestMapping("/pay")
    public Result pay(@RequestBody LinkedList<Cart> cart) {
        System.out.println("发过来的数组为:");
        for (Cart item : cart) {
            System.out.println(item);
        }
        int n=userService.pay_test(cart);
        if(n>0) {return Result.success("支付成功");}
        else return Result.error("支付失败");

    }


}
