package com.eoral.kafkaquickstart;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

  @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.group-id}")
  public void consumeMessage(String message) {
    System.out.println("Received message: " + message);
  }
}
