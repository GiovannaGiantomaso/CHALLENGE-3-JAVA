package com.example.Odontoprev.service;

import com.example.Odontoprev.config.RabbitMQConfig;
import com.example.Odontoprev.model.Tratamento;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TratamentoConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_CREATE)
    public void receberCriacao(Tratamento tratamento) {
        System.out.println("🟢 [TRATAMENTO CRIADO]");
        imprimirTratamento(tratamento);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_UPDATE)
    public void receberAtualizacao(Tratamento tratamento) {
        System.out.println("🟡 [TRATAMENTO ATUALIZADO]");
        imprimirTratamento(tratamento);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_DELETE)
    public void receberExclusao(Tratamento tratamento) {
        System.out.println("🔴 [TRATAMENTO EXCLUÍDO]");
        imprimirTratamento(tratamento);
    }

    private void imprimirTratamento(Tratamento t) {
        System.out.println("ID: " + t.getId());
        System.out.println("Descrição: " + t.getDescricao());
        System.out.println("Tipo: " + t.getTipo());
        System.out.println("Custo: R$ " + t.getCusto());
        System.out.println("------------------------------------");
    }
}
