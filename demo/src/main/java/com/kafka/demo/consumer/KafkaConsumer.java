package com.kafka.demo.consumer;

import com.kafka.demo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

    //@KafkaListener(topics = "kafkaDemo", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info("Consuming msg from topic kafkaDemo");
        log.info(format("Message : %s", msg));

    }

    @KafkaListener(topics = "kafkaDemo", groupId = "myGroup")
    public void MyconsumeMsg(Student msg) {
        log.info("Consuming msg from topic kafkaDemo");
        log.info(format("Message : %s", msg.toString()));

    }
}
