package com.example.after_sky_takeayay.mapper;

import com.example.after_sky_takeayay.pojo.bean.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;

@Mapper
public interface AdminMapper {
    @Select("select COUNT(*) from dish")
    public int dish_count();
    @Select("select * from dish  LIMIT #{limit} OFFSET #{current}")
    public LinkedList<Dish> dish(@Param("limit") int limit,@Param("current") int current);

}
