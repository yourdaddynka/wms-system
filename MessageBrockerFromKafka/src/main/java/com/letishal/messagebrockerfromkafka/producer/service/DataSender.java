package com.letishal.messagebrockerfromkafka.producer.service;

import com.letishal.messagebrockerfromkafka.models.Document;

public interface DataSender {
    void send(Document value);
}
