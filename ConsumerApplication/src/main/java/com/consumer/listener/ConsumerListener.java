package com.consumer.listener;

import com.consumer.dto.Product;
import com.consumer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListener {

    private final ProductRepository productRepository;

    @KafkaListener(topics = "${kafka.topic}")
    public void consume(ConsumerRecord<String,Product> payload){

        productRepository.save(payload.value());
        log.info(payload.value().toString()+" has been saved to the Product table ");

    }




}
