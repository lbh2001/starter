package com.lbh.starter.service.impl;

import com.lbh.starter.utils.ResponseResult;
import com.lbh.starter.mapper.Usermapper;
import com.lbh.starter.pojo.User;
import com.lbh.starter.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author lbh
 * @Date 2021/3/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private Usermapper usermapper;

    @Override
    public ResponseResult<String> register(User user, String verifyCode) {
        return null;
    }
}
