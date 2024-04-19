package com.letisal.WMSystem.kafka;

import com.letisal.WMSystem.models.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    @NonNull
    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage (String message){kafkaTemplate.send("dbProduct",message);}

    @NonNull private final KafkaTemplate<String,Document> kafkaTemplateTest;
    public void sendMessageTest (Document message){kafkaTemplateTest.send("dbProduct",message);}

}
