package com.example.after_sky_takeayay.mapper;


import com.example.after_sky_takeayay.pojo.bean.OperateLog;
import com.example.after_sky_takeayay.pojo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id} and  password=#{password}")
    public User ulogin(@Param("id") int id, @Param("password") String password);

    @Insert("insert into user values (#{id},#{name},#{password},0)")
    public int register(@Param("id") int id,@Param("name") String name, @Param("password") String password);
    @Insert("insert into operatelog values (#{id},#{time},#{className},#{methodName},#{methodParams},#{returnValue},#{costTime})")
    public int logRecord(OperateLog op);
}
