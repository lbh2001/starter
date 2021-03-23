package com.lbh.starter.cache;

import com.lbh.starter.utils.component.RedisUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @Author lbh
 * @Date 2021/3/22
 * @Description: Redis缓存
 */

public class RedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private String id;

    //设置过期时间为30分钟
    private static final Integer EXPIRE_TIME_IN_MINUTE = 30;

    public RedisCache(String id){
        if(id == null){
            throw new IllegalArgumentException("Cache Instance requires an id");
        }
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        try {
            RedisUtils.putObject(key.toString(), value, EXPIRE_TIME_IN_MINUTE, TimeUnit.MINUTES);
            logger.debug("缓存key:[{}],缓存value:[{}]",key.toString(),value);
        } catch (Throwable t){
            logger.error("Redis put fail");
        }
    }

    /**
     * @param key The key
     * @return The object stored in the cache.
     */
    @Override
    public Object getObject(Object key) {
        try{
            Object value = RedisUtils.getObject(key.toString());
            logger.debug("获取缓存key:[{}]",key.toString());
            return value;
        } catch (Throwable t){
            logger.error("Redis get fail");
            return null;
        }
    }

    /**
     *
     * @param key The key
     * @return Not used
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object removeObject(Object key) {
        try{
            RedisUtils.removeObject(key.toString());
            logger.debug("Redis delete success");
        }catch (Throwable t){
            logger.error("Redis delete fail");
        }
        return null;
    }

    /**
     * Clears this cache instance.
     */
    @Override
    public void clear() {
        RedisUtils.clear();
        logger.debug("Redis cache cleared");
    }

    /**
     * Optional. This method is not called by the core.
     *
     * @return The number of elements stored in the cache (not its capacity).
     */
    @Override
    public int getSize() {
        return 0;
    }
}
