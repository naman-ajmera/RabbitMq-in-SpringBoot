package com.example.rabbitMq.rabbitMQ;

import com.example.rabbitMq.rabbitMQ.Message.CustomMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("publish")
public class MessagePublisher {

    private static final String QUEUE = "message_queue1";
    private static final String EXCHANGE = "topic_exchange1";
    private static final String ROUTING = "routing_key1";
    private static final String QUEUE2 = "message_queue2";
    private static final String EXCHANGE2 = "fanout_exchange1";
    private static final String ROUTING2 = "routing_key2";
    private static final String QUEUE3 = "message_queue3";
    private static final String ROUTING3 = "routing_key3";
    private static final String QUEUE4= "message_queue4";
    private static final String ROUTING4 = "routing_key4";



    @Autowired
    private RabbitTemplate template;

    @PostMapping("/topicExchange")
    public String publishTopicMessage(@RequestBody CustomMessage customMessage){
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        template.convertAndSend(EXCHANGE,ROUTING,customMessage);
        template.convertAndSend(EXCHANGE,ROUTING2,customMessage);
        return "Message Published To Topic Exchange";
    }

    @PostMapping("/fanoutExchange")
    public String publishFanoutExchange(@RequestBody CustomMessage customMessage){
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        template.convertAndSend(EXCHANGE2,ROUTING3,customMessage);
        return "Message Published To Fanout Exchange";
    }

    @PostMapping("/")
    public String publishAllExchnages(@RequestBody CustomMessage customMessage){
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        template.convertAndSend(EXCHANGE,ROUTING,customMessage);
        template.convertAndSend(EXCHANGE,ROUTING2,customMessage);
        template.convertAndSend(EXCHANGE2,ROUTING3,customMessage);
        return "Message Published To All Exchanges";
    }


}
