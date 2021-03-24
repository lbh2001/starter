package com.lbh.starter.controller;

import com.lbh.starter.pojo.User;
import com.lbh.starter.service.UserService;
import com.lbh.starter.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lbh
 * @Date 2021/3/21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult<String> register(User user, String verifyCode){
        return userService.register(user,verifyCode);
    }

}
