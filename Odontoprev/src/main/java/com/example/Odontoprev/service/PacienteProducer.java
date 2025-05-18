package com.example.Odontoprev.service;

import com.example.Odontoprev.config.RabbitMQConfig;
import com.example.Odontoprev.model.Paciente;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PacienteProducer {

    private final RabbitTemplate rabbitTemplate;

    public PacienteProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarCriacao(Paciente paciente) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.PACIENTE_CREATE_KEY, paciente);
    }

    public void enviarAtualizacao(Paciente paciente) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.PACIENTE_UPDATE_KEY, paciente);
    }

    public void enviarExclusao(Paciente paciente) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.PACIENTE_DELETE_KEY, paciente);
    }
}
