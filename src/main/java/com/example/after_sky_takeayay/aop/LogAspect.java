package com.example.after_sky_takeayay.aop;

import com.alibaba.fastjson.JSONObject;
import com.example.after_sky_takeayay.mapper.UserMapper;
import com.example.after_sky_takeayay.pojo.bean.OperateLog;
import com.example.after_sky_takeayay.utils.JwtUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Component
@Aspect
public class LogAspect {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(com.example.after_sky_takeayay.aop.XiaoGuo)")
    public Object recordLog( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入了无敌方法");
        Date time = new Date(System.currentTimeMillis());
        String className = proceedingJoinPoint.getClass().getName(); //得到类名
        String methodName = proceedingJoinPoint.getSignature().getName(); //得到方法名
        Object[] args = proceedingJoinPoint.getArgs();
        String methodParams = Arrays.toString(args); //得到方法的参数
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long costTime = end - begin;
        String returnValue = JSONObject.toJSONString(result);
        String token = request.getHeader("Authorization");
        int id;
        if(token==null){ id=(Integer)args[0];}
        else{
            id = (int) JwtUtils.parseToken(token).get("id");
        }
        System.out.println("根据token得到的id为:"+id);
        OperateLog operateLog = new OperateLog(id, time, className, methodName, methodParams, returnValue, costTime);
        userMapper.logRecord(operateLog);
        log.info("AOP记录操作日志 {}", operateLog);
        return result;

    }



}
