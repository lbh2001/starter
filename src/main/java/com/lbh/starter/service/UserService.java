package com.lbh.starter.service;

import com.lbh.starter.Utils.ResponseResult;
import com.lbh.starter.pojo.PO.TokenPO;
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
    ResponseResult<TokenPO> register(User user, String verifyCode);


}
