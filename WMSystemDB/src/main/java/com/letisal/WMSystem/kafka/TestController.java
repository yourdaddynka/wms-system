//package com.letisal.WMSystem.kafka;
//
//import com.letisal.WMSystem.models.Document;
//import com.letisal.WMSystem.models.Product;
//import com.letisal.WMSystem.models.Provider;
//import lombok.AllArgsConstructor;
//import org.apache.kafka.clients.producer.KafkaProducer;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@AllArgsConstructor
//public class TestController {
//
//
//    KafkaProducer kafkaProducer;
//
//    @PostMapping("kafka/consumer/")
//    public void pushMessage(@RequestBody Product product) {
//        kafkaProducer.send(product);
//    }
//
//    @PostMapping("kafka/consumer/")
//    public void pushMessage(@RequestBody Document document) {
//        kafkaProducer.sendMessageDocument(document);
//    }
//
//    @PostMapping("kafka/consumer/")
//    public void pushMessage(@RequestBody Provider provider) {
//        kafkaProducer.sendMessageProvider(provider);
//    }
//
//}
