package com.lbh.starter.service.impl;

import com.lbh.starter.enums.ResponseEnum;
import com.lbh.starter.utils.ResponseResult;
import com.lbh.starter.mapper.UserMapper;
import com.lbh.starter.pojo.User;
import com.lbh.starter.service.UserService;
import com.lbh.starter.utils.component.RedisUtils;
import com.lbh.starter.utils.component.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author lbh
 * @Date 2021/3/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseResult<String> register(User user, String verifyCode) {
        //检测验证码是否正确
        if(!verifyCode.equals(RedisUtils.getObject(user.getPhone()))){
            return ResponseResult.fail(ResponseEnum.VERIFY_CODE_ERROR.getCode(),ResponseEnum.VERIFY_CODE_ERROR.getMsg());
        }

        //判断用户名是否已存在
        if(userMapper.selectByUsername(user.getUsername())!=null){
            return ResponseResult.fail(ResponseEnum.USER_EXISTS.getCode(), ResponseEnum.USER_EXISTS.getMsg());
        }

        user.setPhone(user.getPhone());
        user.setPassword(user.getPassword());
        user.setCreateTime(new Date());

        //持久化数据库
        userMapper.insertUser(user);
        RedisUtils.removeObject(user.getPhone());

        //存入token的信息
        HashMap<String, String> map = new HashMap<>();
        map.put("userId:",user.getUserId().toString());
        map.put("username:",user.getUsername());

        String token = TokenUtils.getToken(map);

        return ResponseResult.ok(token);


    }
}
