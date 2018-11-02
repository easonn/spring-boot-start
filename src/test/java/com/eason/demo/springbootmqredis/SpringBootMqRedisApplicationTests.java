package com.eason.demo.springbootmqredis;

import com.eason.demo.springbootmqredis.repositories.KfRepository;
import com.eason.demo.springbootmqredis.po.Demo;
import com.eason.demo.springbootmqredis.po.Kf;
import com.eason.demo.springbootmqredis.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMqRedisApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    DemoService demoService;

    @Autowired
    KfRepository kfRepository;

    @Test
    public void esTest(){
        Kf kf = new Kf();
        kfRepository.index(kf);
    }

    @Test
    public void contextLoads() {
        stringRedisTemplate.opsForValue().set("demo", "hello");

        Object t = stringRedisTemplate.opsForValue().get("demo");
        System.out.println(new Date() + "" + t);

    }

    @Test
    public void loadDataSource() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void loadRabbitMQ() {
        Demo demo = demoService.selectById(1);
        demo.setRemark("sadfsdf"+new Date());
        rabbitTemplate.convertAndSend("ec.fanout", "rounting1", demo);
    }

    @Test
    public void reciveRabbitMQ() {
        Demo demo = (Demo) rabbitTemplate.receiveAndConvert("demo1");
        System.out.println(demo);
    }


}
