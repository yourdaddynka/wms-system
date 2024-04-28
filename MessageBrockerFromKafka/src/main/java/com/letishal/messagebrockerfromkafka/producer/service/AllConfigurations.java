package com.letishal.messagebrockerfromkafka.producer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.JacksonUtils;

@Configuration
public class AllConfigurations {
    @Value("${kafka.topic.name}") public String topicName;

    @Bean
    public ObjectMapper objectMapper() {
        return JacksonUtils.enhancedObjectMapper();
    }
    @Bean public NewTopic topic() {
        return TopicBuilder.name(topicName).partitions(1).replicas(1).build();
    }
}
