package com.lbh.starter.service;

import com.lbh.starter.utils.ResponseResult;
import com.lbh.starter.pojo.User;

/**
 * @Author lbh
 * @Date 2021/3/21
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     * @param verifyCode
     * @return
     */
    ResponseResult<String> register(User user, String verifyCode);


}
