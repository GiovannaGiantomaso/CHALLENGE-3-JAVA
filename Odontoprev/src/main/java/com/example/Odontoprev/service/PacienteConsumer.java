package com.example.Odontoprev.service;

import com.example.Odontoprev.config.RabbitMQConfig;
import com.example.Odontoprev.model.Paciente;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PacienteConsumer {

    @RabbitListener(queues = RabbitMQConfig.PACIENTE_CREATE_QUEUE)
    public void receberCriacao(Paciente paciente) {
        System.out.println("🟢 [PACIENTE CRIADO]");
        imprimir(paciente);
    }

    @RabbitListener(queues = RabbitMQConfig.PACIENTE_UPDATE_QUEUE)
    public void receberAtualizacao(Paciente paciente) {
        System.out.println("🟡 [PACIENTE ATUALIZADO]");
        imprimir(paciente);
    }

    @RabbitListener(queues = RabbitMQConfig.PACIENTE_DELETE_QUEUE)
    public void receberExclusao(Paciente paciente) {
        System.out.println("🔴 [PACIENTE EXCLUÍDO]");
        imprimir(paciente);
    }

    private void imprimir(Paciente p) {
        System.out.println("ID: " + p.getId());
        System.out.println("Nome: " + p.getNome());
        System.out.println("Email: " + p.getEmail());
        System.out.println("Telefone: " + p.getTelefone());
        System.out.println("--------------------------------------");
    }
}
