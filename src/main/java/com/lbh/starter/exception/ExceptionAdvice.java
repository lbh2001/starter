package com.lbh.starter.exception;

/**
 * @Author lbh
 * @Date 2021/3/20
 */

import com.lbh.starter.utils.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义处理响应异常
 */

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ResponseException.class)
    public ResponseResult<Void> responseExceptionHandler(ResponseException responseException){
        return ResponseResult.fail(responseException.getCode(),responseException.getMsg());
    }

}
