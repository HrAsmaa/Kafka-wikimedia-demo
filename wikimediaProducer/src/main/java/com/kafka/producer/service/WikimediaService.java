package com.kafka.producer.service;

import com.kafka.producer.KafkaProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WikimediaService {

    private final WebClient webClient;
    private final KafkaProducer kafkaProducer;

    public WikimediaService(WebClient.Builder webClientBuilder, KafkaProducer kafkaProducer) {
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.kafkaProducer = kafkaProducer;
    }

    public void getStreamAndProduce(){
        this.webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(kafkaProducer::sendMessage);
    }
}
