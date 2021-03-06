package com.eason.demo.springbootmqredis.service;

import com.eason.demo.springbootmqredis.mapper.DemoMapper;
import com.eason.demo.springbootmqredis.po.Demo;
import com.eason.demo.springbootmqredis.po.Kf;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;




    //@Cacheable(value = "demo", key = "#id")
    public Demo selectById(Integer id) {
        Demo demo = demoMapper.selectById(id);
        return demo;

    }
}
