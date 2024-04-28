package com.letishal.messagebrockerfromkafka.producer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.letishal.messagebrockerfromkafka.models.Document;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.JacksonUtils;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@Configuration
@PropertySource("classpath:KafkaDataset.properties")
public class ApplicationProducerConfig {
    private static final Logger log = LoggerFactory.getLogger(ApplicationProducerConfig.class);

    @Value("${kafka.topic.name}") public String topicName;
//    @Value("${kafka.producer.id}") private String kafkaProducerId;
//    @Value("${kafka.server}") private String kafkaServer;
    @Autowired private KafkaProperties kafkaProperties;
    @Autowired public ObjectMapper objectMapper;


    @Bean
    public Map<String, Object> producerConfig() {
        Map<String, Object> props = kafkaProperties.buildProducerProperties(null);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<Long, Document> producerFactory() {
        var kafkaProduct = new DefaultKafkaProducerFactory<Long, Document>(producerConfig());
        kafkaProduct.setValueSerializer(new JsonSerializer<>(objectMapper));
        return kafkaProduct;
    }

    @Bean
    public KafkaTemplate<Long, Document> kafkaTemplate() {
        KafkaTemplate<Long, Document> template = new KafkaTemplate<>(producerFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }

}



/*
    @Bean
    Map<String,Object> producerConfig(){
        Map<String,Object> props = new HashMap<>();
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }
    @Bean
    public ProducerFactory<Long,Document> producerFactory(){return new DefaultKafkaProducerFactory<>(producerConfig());}

данный поход тоже рабочий, однако он менее гибкий а именно: отсутсвие использования  Boot-инициализатора нашего properties файла
лучше делать через kafkaProperties.buildProducerProperties(null);

Также, если оставить kafkaProduct.setValueSerializer(new JsonSerializer<>()); пустым, то будет стандартная сериалиация, однако,мы явно прописали настройки и указали их

ObjectMapper - объект  для сериализации и десериализации

те бины, что создаются стартером невидимо для нас на фоне, мы выносим наружу и описываем(параметризируем)явно
он создат тех самых продюсеров
 */