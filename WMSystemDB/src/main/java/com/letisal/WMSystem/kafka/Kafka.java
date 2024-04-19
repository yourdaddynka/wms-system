package com.letisal.WMSystem.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Kafka {
    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name("dbProduct")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
