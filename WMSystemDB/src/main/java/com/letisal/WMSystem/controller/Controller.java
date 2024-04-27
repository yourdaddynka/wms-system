package com.letisal.WMSystem.controller;

import com.letisal.WMSystem.models.Document;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping
public class Controller {
    private final Producer producer;
    @PostMapping("/kafka/send")
    @ResponseStatus(HttpStatus.OK)
    public Document sendOrder(@RequestBody Document order) {
        log.info("Send order to kafka");
        producer.sendOrderEvent(order);
        return order;
    }
}
