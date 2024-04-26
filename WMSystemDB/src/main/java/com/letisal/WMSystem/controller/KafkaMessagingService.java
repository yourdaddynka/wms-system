package com.letisal.WMSystem.controller;

import com.letisal.WMSystem.models.Document;
import com.letisal.WMSystem.models.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessagingService {
    @Value("$(${topic.send-order})")
    private String sendProductTopic;
    private final KafkaTemplate<String, Product> kafkaTemplate;


}
