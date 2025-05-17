package com.example.Odontoprev.service;

import com.example.Odontoprev.config.RabbitMQConfig;
import com.example.Odontoprev.model.Tratamento;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class TratamentoProducer {

    private final RabbitTemplate rabbitTemplate;

    public TratamentoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarCriacao(Tratamento tratamento) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_CREATE,
                tratamento
        );
    }

    public void enviarAtualizacao(Tratamento tratamento) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_UPDATE,
                tratamento
        );
    }

    public void enviarExclusao(Tratamento tratamento) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_DELETE,
                tratamento
        );
    }
}
