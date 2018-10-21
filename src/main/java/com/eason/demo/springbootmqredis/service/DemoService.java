package com.eason.demo.springbootmqredis.service;

import com.eason.demo.springbootmqredis.mapper.DemoMapper;
import com.eason.demo.springbootmqredis.po.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    CacheManager cacheManager;

    @Cacheable(value = "demo", key = "#id")
    public Demo selectById(Integer id) {
        System.out.println(cacheManager.getClass());
        Demo demo = demoMapper.selectById(id);
        return demo;
    }
}
