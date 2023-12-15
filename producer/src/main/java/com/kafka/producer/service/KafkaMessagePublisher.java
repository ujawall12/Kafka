package com.kafka.producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaMessagePublisher {

    private final KafkaTemplate<String, Object> template; // to talk to Kafka server

    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("test-topic-springboot", message);
        future.whenComplete((result,exception) -> {
            if(exception != null){
                System.out.println("Exception: " + exception.getMessage());
            }
            else{
                System.out.println("Sent Message: " + message+ " with offset: "
                        + result.getRecordMetadata().offset()+
                        " to topic: " + result.getRecordMetadata().topic()+
                        " partition: "+result.getRecordMetadata().partition());
            }
        });
    }
}
