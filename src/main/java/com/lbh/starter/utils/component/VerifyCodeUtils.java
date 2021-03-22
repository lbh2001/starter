package com.lbh.starter.utils.component;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 生成6位随机验证码
 *
 * @Author lbh
 * @Date 2021/3/22
 */

@Component
public class VerifyCodeUtils {

    private static final String number = "0123456789";

    public static String getVerifyCode(){
        StringBuilder stringBuilder = new StringBuilder(6);
        char temp;

        for (int i = 0; i < 6; i++) {
            temp = number.charAt(new Random().nextInt(number.length()));
            stringBuilder.append(temp);
        }

        return stringBuilder.toString();
    }

}
