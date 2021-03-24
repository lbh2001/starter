package com.lbh.starter.mapper;

import com.lbh.starter.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @Author lbh
 * @Date 2021/3/21
 */

public interface UserMapper {

    //添加用户
    int insertUser(User user);

    //根据用户名查询用户
    User selectByUsername(String username);

}
