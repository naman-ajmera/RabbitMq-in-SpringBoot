package com.example.rabbitMq.rabbitMQ.Config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

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

    @Bean
    public Queue queue1(){
        return new Queue(QUEUE);
    }

    @Bean
    public Queue queue2(){
        return new Queue(QUEUE2);
    }

    @Bean
    public Queue queue3(){
        return new Queue(QUEUE3);
    }

    @Bean
    public Queue queue4(){
        return new Queue(QUEUE4);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(EXCHANGE2);
    }

    @Bean
    Binding binding1(TopicExchange topicExchange) {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with(ROUTING);
    }

    @Bean
    Binding binding2(TopicExchange topicExchange) {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with(ROUTING2);
    }

    @Bean
    Binding binding3(FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue3()).to(fanoutExchange());
    }

    @Bean
    Binding binding4(FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue4()).to(fanoutExchange());
    }

    @Bean
    Binding binding5(FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate((connectionFactory));
        rabbitTemplate.setMessageConverter(messageConverter());
        return  rabbitTemplate;
    }

}
