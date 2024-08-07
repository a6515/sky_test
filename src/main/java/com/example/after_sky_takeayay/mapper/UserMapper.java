package com.example.after_sky_takeayay.mapper;


import com.example.after_sky_takeayay.pojo.bean.*;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id} and  password=#{password}")
    public User ulogin(@Param("id") int id, @Param("password") String password);

    @Insert("insert into user values (#{id},#{name},#{password},0)")
    public int register(@Param("id") int id,@Param("name") String name, @Param("password") String password);
    @Insert("insert into operatelog values (#{id},#{time},#{className},#{methodName},#{methodParams},#{returnValue},#{costTime})")
    public int logRecord(OperateLog op);

    @Select("select * from category")
    public LinkedList<Category> getCategory();
    @Select("select * from dish")
    public LinkedList<Dish> getDish();
    @Insert("insert into cart values (#{id},#{dish_id},#{dish_name},#{number},#{unit_price}) ")
    public int addCart(@Param("id") int id,@Param("dish_id") int dish_id,@Param("dish_name") String dish_name,@Param("number") int number,@Param("unit_price") float unit_price);

    @Select("select * from cart where id=#{id} and dish_id=#{dish_id}")
    public Cart findById_Cart(@Param("id") int id,@Param("dish_id") int dish_id);
    @Update("update cart set number=number+1  where id=#{id} and dish_id=#{dish_id}")
    public int addCart_exact(@Param("id") int id,@Param("dish_id") int dish_id);

    @Select("select * from cart where id=#{id}")
    public LinkedList<Cart> getCart(@Param("id") int id);
    @Update("update cart set number=number-1 where id=#{id} and dish_id=#{dish_id}")
    public int sub_item(@Param("id") int id,@Param("dish_id") int dish_id);
    @Update("update cart set number=number+1 where id=#{id} and dish_id=#{dish_id}")
    public int add_item(@Param("id") int id,@Param("dish_id") int dish_id);
    @Update("delete from cart where id=#{id} and dish_id=#{dish_id}")
    public int remove_item(@Param("id") int id,@Param("dish_id") int dish_id);
    @Insert("insert into orders values (#{order_id},#{id},NOW(),#{sum_price})")
    @Options(useGeneratedKeys = true, keyProperty = "order_id", keyColumn = "order_id")
    public int pay(Orders orders);

    @Insert("insert into order_detials values (#{orderDetial_id},#{order_id},#{dish_id},#{dish_name},#{number},#{price},CURDATE())")
    public int order_detial(OrderDetials orderDetials);
    @Delete("delete from cart where id=#{id}")
    public int cart_remove(@Param("id") int id);

    @Insert({
            "<script>",
            "INSERT INTO order_detials VALUES ",
            "<foreach collection='orderDetailsList' item='item' separator=','>",
            "(#{item.orderDetial_id}, #{item.order_id}, #{item.dish_id}, #{item.dish_name}, #{item.number}, #{item.price}, CURDATE())",
            "</foreach>",
            "</script>"
    })
    public int forEachInsertOrderDetails(@Param("orderDetailsList") List<OrderDetials> orderDetailsList);
}
