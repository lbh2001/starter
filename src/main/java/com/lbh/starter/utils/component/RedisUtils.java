package com.lbh.starter.utils.component;

import com.lbh.starter.cache.RedisCache;
import com.lbh.starter.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis缓存工具类
 *
 * @Author lbh
 * @Date 2021/3/21
 */
@Component
public class RedisUtils {

    @Autowired
    private static RedisTemplate redisTemplate;

    //不设置String类型过期时间
    public static void putObject(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    //设置String类型过期时间
    public static void putObject(String key, Object value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    //从缓存中读取String类型值
    public static Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    //设置Hash类型
    public static void putHashObject(String key,Object hashKey,Object value){
        redisTemplate.opsForHash().put(key,hashKey,value);
    }

    //查询Hash类型
    public static Object getHashObject(String key,Object hashKey){
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    //移除某个键值对
    public static void removeObject(Object key) {
        redisTemplate.delete(key);
    }

    //清楚缓存
    public static void clear(){
        redisTemplate.execute((RedisCallback) connection->{
            connection.flushDb();
            return null;
        });
    }

    public static int getSize() {
        return 0;
    }

}
