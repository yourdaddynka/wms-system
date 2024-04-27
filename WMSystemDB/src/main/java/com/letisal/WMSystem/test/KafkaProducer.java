//package com.letisal.WMSystem.test;
//
//import com.letisal.WMSystem.models.Document;
//import com.letisal.WMSystem.models.Product;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class KafkaProducer {
//    @NonNull
//    KafkaTemplate<String,String> kafkaTemplate;
//    public void sendMessage(String s){kafkaTemplate.send("TESTCONNECT",s);}
//
//
//    @NonNull
//    KafkaTemplate<String, Document> kafkaTemplateTest;
//    public void sendMessageTest(Document document){kafkaTemplateTest.send("TESTCONNECT",document);}
//
//}
