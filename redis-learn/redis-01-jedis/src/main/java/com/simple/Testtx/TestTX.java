package com.simple.Testtx;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author Simple
 * @date 2021/3/21 17:04
 */
public class TestTX {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);

        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","simple");

        //开启事务
        Transaction multi =jedis.multi();
        String result = jsonObject.toString();

        try {
            multi.set("user1",result);
            multi.set("user2",result);

            multi.exec();
        }catch (Exception e){
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }




    }
}
