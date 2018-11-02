package com.eason.demo.springbootmqredis.repositories;

import com.eason.demo.springbootmqredis.po.Kf;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface KfRepository extends ElasticsearchRepository<Kf, String> {
}
