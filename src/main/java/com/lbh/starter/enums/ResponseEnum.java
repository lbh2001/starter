package com.lbh.starter.enums;

/**
 * @Author lbh
 * @Date 2021/3/17
 */
public enum ResponseEnum {
    SUCCESS(1,"成功"),
    FAIL(0,"失败"),

    //用户模块状态码
    VERIFY_CODE_ERROR(1000,"验证码错误"),
    USER_EXISTS(1001,"用户已存在"),
    PASSWORD_ERROR(1002,"密码错误")
    ;



    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String msg;

    ResponseEnum(int code, String msg){
        this.code=code;
        this.msg=msg;
    }


    public int getCode(){
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
