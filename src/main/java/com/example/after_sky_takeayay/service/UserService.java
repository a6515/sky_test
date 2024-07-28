package com.example.after_sky_takeayay.service;

import com.example.after_sky_takeayay.pojo.bean.OperateLog;
import com.example.after_sky_takeayay.pojo.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public User ulogin(int id,  String password);
    public int register(String name, String password);
}
