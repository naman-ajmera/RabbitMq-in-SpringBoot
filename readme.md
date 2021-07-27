**This is a project on RabbitMq in Spring Boot.**

**How My RabbitMq Architecture looks like:**

[](https://user-images.githubusercontent.com/36277015/126775205-17a5dc1f-a521-4478-9bdc-947007c83108.png)

  **Exchange**: 2 Exchanges: 1. Topic Exchange
                             2. Fanout Exchange
     
  **Queues**: 4 Queues: 1. Queue Name:

**Run RabbitMq in docker:**
  1. run command: docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

**Run SpringBoot Project:**
  1. run main application.
  2. Access /publish with body {"message":"message to publish"} using Postman to Publish to All Exchanges.
  3. Access /publish/fanoutExchange with body {"message":"message to publish"} using Postman to Publish to Fanout Exchanges.
  4. Access /publish/topicExchange with body {"message":"message to publish"} using Postman to Publish to Topic Exchanges.


