package com.javaResource.rm.api.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.javaResource.rm.api.config.MessagingConfig;
import com.javaResource.rm.api.dto.OrderStatus;

@Component
public class User {
	
	
	//@RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
    }

}
