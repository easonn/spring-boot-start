package com.eason.demo.springbootmqredis.service;

import com.eason.demo.springbootmqredis.repositories.KfRepository;
import com.eason.demo.springbootmqredis.po.Kf;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RabbitListener(queues = {"demo1"})
public class KfService {

    @Autowired
    KfRepository kfRepository;

    @RabbitHandler
    public void process(@Payload Kf kf) {
        kfRepository.save(kf);
        System.out.println(new Date() + "" + kf);
    }
}
