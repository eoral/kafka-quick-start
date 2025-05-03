package com.eoral.kafkaquickstart;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

  private final KafkaProducer kafkaProducer;

  public DefaultController(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  @GetMapping("send-message")
  public void sendMessage() {
    kafkaProducer.sendMessage("This message was created at " + LocalDateTime.now());
  }
}
