package com.toskafx.kafkaservice.controller;

import com.toskafx.kafkaservice.kafka.KafkaProducer;
import com.toskafx.kafkaservice.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/publish")
    public ResponseEntity<?> publishMessage(@RequestBody User data){
        kafkaProducer.sendJsonMessage(data);

        return ResponseEntity.ok("Json Message sent to Topic successfully");
    }
}
