package com.springdata.rabbitmq.consumer;

import com.springdata.rabbitmq.config.MessagingConfig;
import com.springdata.rabbitmq.dto.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Message message){
        System.out.println("Message => "+ message.toString());
    }
}
