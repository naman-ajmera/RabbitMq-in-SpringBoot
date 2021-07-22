package com.example.rabbitMq.rabbitMQ;

import com.example.rabbitMq.rabbitMQ.Message.CustomMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final String QUEUE = "message_queue1";
    private static final String EXCHANGE = "topic_exchange1";
    private static final String ROUTING = "routing_key1";
    private static final String QUEUE2 = "message_queue2";
    private static final String EXCHANGE2 = "topic_exchange2";
    private static final String ROUTING2 = "routing_key2";
    private static final String QUEUE3 = "message_queue3";
    private static final String ROUTING3 = "routing_key3";
    private static final String QUEUE4= "message_queue4";
    private static final String ROUTING4 = "routing_key4";

    @RabbitListener(queues = QUEUE3)
    public void listenMessage(CustomMessage message){
        System.out.println(message.getMessage()+"fanoutExchange linked to Q3");
    }

    @RabbitListener(queues = {QUEUE,QUEUE2})
    public void listenMessage1(CustomMessage message){
        System.out.println(message.getMessage()+"topicExchange linked to Q1, Q2");
    }

    @RabbitListener(queues = QUEUE4)
    public void listenMessage2(CustomMessage message){
        System.out.println(message.getMessage()+"fanoutExchange linked to Q4");
    }

}
