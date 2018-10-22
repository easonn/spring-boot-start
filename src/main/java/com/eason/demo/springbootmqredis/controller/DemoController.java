package com.eason.demo.springbootmqredis.controller;

import com.eason.demo.springbootmqredis.po.Demo;
import com.eason.demo.springbootmqredis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "hello/{id}")
    public Demo hello(@PathVariable("id") Integer id) {
        Demo demo = demoService.selectById(id);
        return demo;
    }
}
