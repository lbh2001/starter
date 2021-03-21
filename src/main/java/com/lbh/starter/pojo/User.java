package com.lbh.starter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author lbh
 * @Date 2021/3/21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户性别
     */
    private Byte gender;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户生日
     */
    private Date birth;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 注册时间
     */
    private Date createTime;
}
