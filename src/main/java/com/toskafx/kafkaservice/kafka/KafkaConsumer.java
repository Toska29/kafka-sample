package com.toskafx.kafkaservice.kafka;

import com.toskafx.kafkaservice.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {"new-user"}, groupId = "myGroup")
    public void consumerMessages(String message){
        LOG.info("Message received is -> {}", message);
    }

    @KafkaListener(topics = {"json-new-user"}, groupId = "myGroup")
    public void consumeMessages(User data){
        LOG.info("Json Message received -> {}", data.toString());
    }
}
