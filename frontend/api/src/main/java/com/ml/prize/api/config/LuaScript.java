package com.ml.prize.api.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/3/16
 */
@Service
public class LuaScript {

    @Resource
    private RedisTemplate redisTemplate;
    private DefaultRedisScript<Long> defaultRedisScript;

    @PostConstruct
    public void init() {
        defaultRedisScript = new DefaultRedisScript<Long>();
        defaultRedisScript.setResultType(Long.class);
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/tokenCheck.lua")));
    }

    public Long tokenCheck(String gameKey, String currentTime) {
        List<String> keys = new ArrayList();
        keys.add(gameKey);
        keys.add(currentTime);

        Long result = (Long) redisTemplate.execute(defaultRedisScript, keys, 0, 0);
        return result;
    }

}
