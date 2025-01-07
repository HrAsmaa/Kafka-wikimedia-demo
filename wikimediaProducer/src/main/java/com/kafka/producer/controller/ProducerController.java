package com.kafka.producer.controller;


import com.kafka.producer.KafkaProducer;
import com.kafka.producer.service.WikimediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final WikimediaService wikimediaService;

    @PostMapping("/produce")
    public ResponseEntity<String> sendMessage() {
        wikimediaService.getStreamAndProduce();
        return ResponseEntity.ok("data produced successfully");
    }
}
