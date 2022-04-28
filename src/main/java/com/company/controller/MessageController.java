package com.company.controller;

import com.company.resource.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/messages")
public class MessageController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public HttpStatus publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("yasin", request.getMessage());
        return HttpStatus.OK;
    }
}
