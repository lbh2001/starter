package com.lbh.starter.pojo.PO;

import com.lbh.starter.pojo.User;
import lombok.Data;

/**
 * 用户及其token
 *
 * @Author lbh
 * @Date 2021/3/21
 */

@Data
public class TokenPO {

    /**
     * 用户
     */
    private User user;
    /**
     * token
     */
    private String token;

    public TokenPO(User user,String token){
        this.user=user;
        this.token=token;
    }


}
