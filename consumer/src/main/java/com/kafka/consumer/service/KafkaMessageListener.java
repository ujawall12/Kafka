package com.kafka.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "test-topic-springboot", groupId = "consumer_group_1")
    public void consume(String message) {
        log.info(String.format("#### -> Consumed message by consumer -> %s", message));
    }

    @KafkaListener(topics = "test-topic-springboot", groupId = "consumer_group_1")
    public void consume1(String message) {
        log.info(String.format("#### -> Consumed message by consumer 1 -> %s", message));
    }

    @KafkaListener(topics = "test-topic-springboot", groupId = "consumer_group_1")
    public void consume2(String message) {
        log.info(String.format("#### -> Consumed message by consumer 2 -> %s", message));
    }

    @KafkaListener(topics = "test-topic-springboot", groupId = "consumer_group_1")
    public void consume3(String message) {
        log.info(String.format("#### -> Consumed message by consumer 3 -> %s", message));
    }

    @KafkaListener(topics = "test-topic-springboot", groupId = "consumer_group_1")
    public void consume4(String message) {
        log.info(String.format("#### -> Consumed message by consumer 4 -> %s", message));
    }
}
