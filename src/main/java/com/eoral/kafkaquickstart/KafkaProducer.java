package com.eoral.kafkaquickstart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  private final String topic;

  public KafkaProducer(
      KafkaTemplate<String, String> kafkaTemplate,
      @Value("${spring.kafka.topic.name}") String topic) {
    this.kafkaTemplate = kafkaTemplate;
    this.topic = topic;
  }

  public void sendMessage(String message) {
    kafkaTemplate.send(topic, message);
  }
}
