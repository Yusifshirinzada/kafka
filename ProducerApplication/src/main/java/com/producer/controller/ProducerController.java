package com.producer.controller;

import com.producer.dto.Product;
import com.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer")
@RequiredArgsConstructor
public class ProducerController {


   private final ProducerService producerService;

    @GetMapping
    public String healthCheck(@RequestBody Object message){

        producerService.send(message);

        return "Message is sent successfully";
    }

    @PostMapping
    public Product sendProductMessage(@RequestBody Product message){

        producerService.send(message);
        return message;
    }
}
