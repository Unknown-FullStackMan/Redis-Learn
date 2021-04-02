package com.simple.TestPing;

import redis.clients.jedis.Jedis;

/**
 * @author Simple
 * @date 2021/3/21 16:48
 */
public class Testping {
    public static void main(String[] args) {

        //创建Jedis对象即可
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //jedis所有命令就是redis的指令
        System.out.println(jedis.ping());

//
//        System.out.println("清空数据："+jedis.flushDB());
//        System.out.println("判断username是否存在"+jedis.exists("username"));
    }
}
