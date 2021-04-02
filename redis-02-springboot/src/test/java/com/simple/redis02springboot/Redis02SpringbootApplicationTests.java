package com.simple.redis02springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.redis02springboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //redisTemple
        //opsForValue 操作字符串 类似String
        //opsForList 操作字符串 类似list
        //opsForSet 操作字符串 类似set
        //opsForZset opsForHash

        //获取redis连接对象
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
//        redisConnection.flushDb();
//        redisConnection.flushAll();
        redisTemplate.opsForValue().set("mykey1","simple");
        System.out.println(redisTemplate.opsForValue().get("mykey1"));
    }

    @Test
    void test() throws JsonProcessingException {
        User user = new User("simple",1);
       // String jsonuser = new ObjectMapper().writeValueAsString(user);  //
        redisTemplate.opsForValue().set("user",user); //不重写redistempale直接传递对象user 会报错
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
