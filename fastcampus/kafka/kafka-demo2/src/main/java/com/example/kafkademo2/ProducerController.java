package com.example.kafkademo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaProduceService kafkaProduceService;

    @RequestMapping("/publish")
    public String publish(String message) {
        kafkaProduceService.send(message);

        return "publish a message :" + message;
    }

    @RequestMapping("/publish2")
    public String publish2(String message) {
        kafkaProduceService.sendWithCallback(message);

        return "publish a message with callback: " + message;
    }

    @RequestMapping("/publish3")
    public String publishJson(MyMessage message) {
        kafkaProduceService.sendJson(message);

        return "publish a message with callback: " + message.getName() + "." + message.getMessage();
    }
}
