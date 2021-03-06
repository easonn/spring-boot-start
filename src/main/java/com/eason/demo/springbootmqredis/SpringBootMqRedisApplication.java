package com.eason.demo.springbootmqredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableRabbit
@SpringBootApplication
@MapperScan("com.eason.demo.springbootmqredis.mapper")
public class SpringBootMqRedisApplication {

    public static void main(String[] args) {
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(SpringBootMqRedisApplication.class, args);
    }
}
