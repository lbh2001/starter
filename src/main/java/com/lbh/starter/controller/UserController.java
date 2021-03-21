package com.lbh.starter.controller;

import com.lbh.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
