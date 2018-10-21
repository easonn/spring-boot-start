package com.eason.demo.springbootmqredis.mapper;


import com.eason.demo.springbootmqredis.po.Demo;
import org.apache.ibatis.annotations.Select;

public interface DemoMapper {

    @Select("SELECT * FROM Demo WHERE id = #{id}")
    Demo selectById(Integer id);

}
