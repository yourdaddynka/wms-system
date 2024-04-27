package com.letisal.WMSystem.controller;

import com.letisal.WMSystem.models.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    @NonNull private final KafkaProducerService kafkaMessagingService;

    @Autowired
    private final ModelMapper modelMapper;

    public Document sendOrderEvent(Document order) {
        kafkaMessagingService.sendOrder(modelMapper.map(order, Document.class));
        return order;
    }
}
