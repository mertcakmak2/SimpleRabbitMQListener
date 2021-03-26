package com.springdata.rabbitmq.controllers;

import com.springdata.rabbitmq.config.MessagingConfig;
import com.springdata.rabbitmq.dto.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/message")
public class MainController {

    @Autowired
    private RabbitTemplate template;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String test(){
        return "test";
    }
    @RequestMapping(value = {""}, method = RequestMethod.POST)
    private String getMessage(@RequestBody Message message ){
        message.setId(UUID.randomUUID().toString());

        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTİNG_KEY, message);
        return "Success";
    }


}
