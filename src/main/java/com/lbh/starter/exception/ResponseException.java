package com.lbh.starter.exception;

/**
 * @Author lbh
 * @Date 2021/3/20
 */

/**
 * 响应异常
 */

public class ResponseException extends RuntimeException{

    /**
     * 异常状态码
     */
    private int code;

    /**
     * 异常信息
     */
    private String msg;

    /**
     * 构造响应异常信息
     * @param message
     * @param code
     * @param msg
     */
    public ResponseException(String message,int code,String msg){
        super(message);
        this.code=code;
        this.msg=msg;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
