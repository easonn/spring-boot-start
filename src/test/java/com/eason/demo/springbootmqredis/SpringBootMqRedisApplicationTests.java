package com.eason.demo.springbootmqredis;

import com.alibaba.druid.pool.ha.selector.DataSourceSelector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMqRedisApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("demo", "hello");

        Object t = redisTemplate.opsForValue().get("demo");
        System.out.println(t);

    }

    @Test
    public void loadDataSource() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
