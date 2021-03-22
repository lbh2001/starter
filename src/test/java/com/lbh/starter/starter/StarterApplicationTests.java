package com.lbh.starter.starter;

import com.lbh.starter.utils.component.VerifyCodeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class StarterApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        System.out.println(VerifyCodeUtils.getVerifyCode());


    }

}
