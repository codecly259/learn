package com.codecly.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

/**
 * @ClassName UserRedis
 * @Description 用户信息的redis存取
 * @Author maxinchun
 * @Date 2018/10/6 02:07
 */
public class UserRedis {


    public User getUser(String key) {
        Jedis jedis = new Jedis("localhost", 6379);
        String result = jedis.get(key);
        return JSONObject.parseObject(result, User.class);
    }

    public void setUser(User user, String key) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set(key, JSONObject.toJSONString(user));
    }

}
