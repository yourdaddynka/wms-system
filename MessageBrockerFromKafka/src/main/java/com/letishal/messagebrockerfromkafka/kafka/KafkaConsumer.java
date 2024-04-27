package com.letishal.messagebrockerfromkafka.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "TESTCONNECT", groupId = "TESTCONNECT")
    public void test(Object message) {
        System.out.println("получено сообщение: " + message);
    }
}


