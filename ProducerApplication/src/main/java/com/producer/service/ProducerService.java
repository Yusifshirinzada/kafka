package com.producer.service;

import com.producer.ProducerApplication;
import com.producer.dto.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;
    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Object message){
        this.kafkaTemplate.send(topic,message);
        System.out.println("Message is sent to kafka: "+message);
    }

    @PostConstruct
    public void generateMessage(){
        Product product=new Product("Iphone","Apple phone","Black",1400,true);
        send(product);
        System.out.println("Message is sent to kafka "+product);
    }




}
