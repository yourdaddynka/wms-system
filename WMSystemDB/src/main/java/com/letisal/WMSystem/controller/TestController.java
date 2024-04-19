package com.letisal.WMSystem.controller;

import com.letisal.WMSystem.kafka.KafkaProducer;
import com.letisal.WMSystem.models.Document;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class TestController {
    KafkaProducer kafkaProducer;

    @PostMapping("kafka/message/")
    public String pushMessage(@RequestBody String messages) {
        kafkaProducer.sendMessage(messages);
        return "Sucess";
    }

    @PostMapping("kafka/message/test/")
    public String pushMessage(@RequestBody Document messages) {
        System.out.println(messages);
        kafkaProducer.sendMessageTest(messages);
        return "Sucess test";
    }
}
