package com.example.after_sky_takeayay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void redisTestTemplate(){
        String test = (String) redisTemplate.opsForHash().get("student","name");
        System.out.println(test);
    }
}
