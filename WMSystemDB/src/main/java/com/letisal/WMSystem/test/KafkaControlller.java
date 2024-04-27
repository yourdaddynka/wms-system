//package com.letisal.WMSystem.test;
//
//import com.letisal.WMSystem.models.Document;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class KafkaControlller {
//    @NonNull KafkaProducer kafkaProducer;
//
//        @PostMapping("/kafka/send") public String send(@RequestBody Document message){kafkaProducer.sendMessage(message.toString());return "success " + message;}
////    @PostMapping("/kafka/send")
////    public String send(@RequestBody Document message) {
////        kafkaProducer.sendMessageTest(message);
////        return "success " + message;
////    }
//}
