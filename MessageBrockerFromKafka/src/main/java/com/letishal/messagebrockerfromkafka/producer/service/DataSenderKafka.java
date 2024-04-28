package com.letishal.messagebrockerfromkafka.producer.service;

import com.letishal.messagebrockerfromkafka.models.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.function.Consumer;

public class DataSenderKafka implements DataSender {

    private static final Logger log = LoggerFactory.getLogger(DataSenderKafka.class);
    private final KafkaTemplate<Long, Document> template;

    private final Consumer<Document> sendAsk;

    private final String topic;

    public DataSenderKafka(KafkaTemplate<Long, Document> template, Consumer<Document> sendAsk, String topic) {
        this.template = template;
        this.sendAsk = sendAsk;
        this.topic = topic;
    }

    @Override
    public void send(Document value) {
        log.info("value:{}", value);
        try {
            template.send(topic, value)
                    .whenComplete(
                            (result, ex) -> {
                                if (ex == null) {
                                    log.info("message id:{} was sent, offset:{}", value.getId(), result.getRecordMetadata().offset());
                                    sendAsk.accept(value);
                                } else {
                                    log.error("message id:{} was not sent", value.getId(), ex);
                                }
                            });

        } catch (Exception ex) {
            log.error("send error,value:{}", value, ex);
        }
    }
}

