package com.toskafx.kafkaservice.controller;

import com.toskafx.kafkaservice.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<?> publishMessage(@RequestParam String message){
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Message sent to Topic successfully");
    }
}
