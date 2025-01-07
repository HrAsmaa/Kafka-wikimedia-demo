package com.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import static java.lang.String.format;
import org.springframework.kafka.annotation.KafkaListener;


@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "wikimediaTopic", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info("Consuming msg from topic wikimediaTopic");
        log.info(format("Message : %s", msg));

    }

}
