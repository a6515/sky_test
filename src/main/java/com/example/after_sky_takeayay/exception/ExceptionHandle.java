package com.example.after_sky_takeayay.exception;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.after_sky_takeayay.pojo.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/*全局异常处理器*/
@RestControllerAdvice
public class ExceptionHandle {
    @Autowired
    HttpServletResponse response;

    // 处理 BadSqlGrammarException
    @ExceptionHandler(BadSqlGrammarException.class)
    public Result handleBadSqlGrammarException(BadSqlGrammarException ex) {
        ex.printStackTrace();
        return Result.error("SQL 语法错误，请检查 SQL 语句的列数与值数是否匹配");
    }

    // 处理 NullPointerException
    @ExceptionHandler(NullPointerException.class)
    public Result handleNullPointerException(NullPointerException ex) {
        ex.printStackTrace();
        return Result.error("空指针异常，请检查是否有未初始化的对象");
    }

    // 处理 IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public Result handleIllegalArgumentException(IllegalArgumentException ex) {
        ex.printStackTrace();
        return Result.error("非法参数异常，请检查传入的参数是否正确");
    }

    //处理TokenExpiredException
    @ExceptionHandler(TokenExpiredException.class)
    public Result handleTokenExpiredException(TokenExpiredException ex){
        ex.printStackTrace();
        response.setStatus(998);
        return Result.error("token过期了，请重新登录");
    }

    // 处理其他所有未处理的异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex) {
        ex.printStackTrace();
        return Result.error("未知错误,请联系小郭管理员");
    }
}
