package com.letishal.messagebrockerfromkafka.kafka;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "dbProduct",groupId = "my_consumer")
    public void listen(String message ){System.out.println("получено сообщение: " + message);}

    @KafkaListener(topics = "dbProduct",groupId = "my_consumer")
    public void test(Object message ){System.out.println("получено сообщение: " + message);}
//    ConsumerRecord
}
