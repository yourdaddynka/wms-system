package com.letishal.messagebrockerfromkafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.letishal.messagebrockerfromkafka.models.Document;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;


import java.util.Map;

@Configuration
public class ApplicationConsumerConfig {

    private static final Logger log = LoggerFactory.getLogger(ApplicationProducerConfig.class);

//    @Value("${kafka.producer.id}") private String kafkaProducerId;
//    @Value("${kafka.server}") private String kafkaServer;
    @Autowired private KafkaProperties kafkaProperties;
    @Autowired public ObjectMapper objectMapper;

    @Bean
    public Map<String, Object> consumerConfig() {
        Map<String, Object> props = kafkaProperties.buildConsumerProperties(null);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,3);//количество значений которое прочитаем при обращении к кафке
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,3_000);//максимальный временной интервал между обращениями
        return props;
    }

    @Bean
    public ConsumerFactory<Long, Document> consumerFactory() {
        var kafkaConsumer = new DefaultKafkaConsumerFactory<Long,Document>(consumerConfig());
        kafkaConsumer.setValueDeserializer(new JsonDeserializer<>(objectMapper));
        return kafkaConsumer;
    }

    @Bean("listenerContainerFactory")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Long,Document>> listenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<Long,Document> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setBatchListener(true);
        factory.setConcurrency(1);
        factory.getContainerProperties().setIdleBetweenPolls(1_000);
        factory.getContainerProperties().setPollTimeout(1_000);
        var executor = new SimpleAsyncTaskExecutor("k-consumer-");
        executor.setConcurrencyLimit(10);
        var listenerTaskExecutor = new ConcurrentTaskExecutor(executor);
        factory.getContainerProperties().setListenerTaskExecutor(listenerTaskExecutor);
        return factory;
    }


    @Bean
    public StringValueConsumer

    }

}
