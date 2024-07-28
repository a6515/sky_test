package com.example.after_sky_takeayay.exception;

import com.example.after_sky_takeayay.pojo.dto.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*全局异常处理器*/
@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("未知错误,请联系小郭管理员");
    }

}
