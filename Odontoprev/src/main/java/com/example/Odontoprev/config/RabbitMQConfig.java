package com.example.Odontoprev.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // criacao
    public static final String QUEUE_CREATE = "tratamento.create";
    public static final String ROUTING_CREATE = "tratamento.create.key";

    // atualizacao
    public static final String QUEUE_UPDATE = "tratamento.update";
    public static final String ROUTING_UPDATE = "tratamento.update.key";

    // exclusao
    public static final String QUEUE_DELETE = "tratamento.delete";
    public static final String ROUTING_DELETE = "tratamento.delete.key";

    // Exchange comum
    public static final String EXCHANGE_NAME = "tratamento.exchange";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue queueCreate() {
        return new Queue(QUEUE_CREATE, true);
    }

    @Bean
    public Queue queueUpdate() {
        return new Queue(QUEUE_UPDATE, true);
    }

    @Bean
    public Queue queueDelete() {
        return new Queue(QUEUE_DELETE, true);
    }

    @Bean
    public Binding bindingCreate() {
        return BindingBuilder.bind(queueCreate()).to(exchange()).with(ROUTING_CREATE);
    }

    @Bean
    public Binding bindingUpdate() {
        return BindingBuilder.bind(queueUpdate()).to(exchange()).with(ROUTING_UPDATE);
    }

    @Bean
    public Binding bindingDelete() {
        return BindingBuilder.bind(queueDelete()).to(exchange()).with(ROUTING_DELETE);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
