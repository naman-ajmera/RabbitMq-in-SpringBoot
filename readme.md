**This is a project on RabbitMq in Spring Boot.**

**How My RabbitMq Architecture looks like:**

  **Exchange**: 2 Exchanges: 1. Topic Exchange
                             2. Fanout Exchange
     
  **Queues**: 4 Queues: 1. Queue Name:

**Run RabbitMq in docker:**
  1. run command: docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

**Run SpringBoot Project:**
  1. run main application.
  2. access /publish with body {"message":"message to publish"} using Postman.
