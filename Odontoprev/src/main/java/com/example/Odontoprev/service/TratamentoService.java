package com.example.Odontoprev.service;

import com.example.Odontoprev.model.Tratamento;
import com.example.Odontoprev.repository.TratamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TratamentoService {

    private static final Logger logger = LoggerFactory.getLogger(TratamentoService.class);

    @Autowired
    private TratamentoRepository tratamentoRepository;

    @Autowired
    private TratamentoProducer tratamentoProducer;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Tratamento> listarTodos() {
        return tratamentoRepository.findAll();
    }

    public Optional<Tratamento> buscarPorId(Long id) {
        return tratamentoRepository.findById(id);
    }

    public Tratamento salvar(Tratamento tratamento) {
        logger.info("Salvando tratamento: Descrição={}, Tipo={}, Custo={}",
                tratamento.getDescricao(), tratamento.getTipo(), tratamento.getCusto());

        if (StringUtils.isBlank(tratamento.getDescricao()) ||
                StringUtils.isBlank(tratamento.getTipo()) ||
                tratamento.getCusto() == null) {
            logger.error("Erro: Campos obrigatórios não preenchidos.");
            throw new IllegalArgumentException("Todos os campos são obrigatórios.");
        }

        boolean isUpdate = tratamento.getId() != null && tratamentoRepository.existsById(tratamento.getId());

        Tratamento salvo = tratamentoRepository.save(tratamento);

        if (isUpdate) {
            tratamentoProducer.enviarAtualizacao(salvo);
        } else {
            tratamentoProducer.enviarCriacao(salvo);
        }

        return salvo;
    }

    @Transactional
    public void deletar(Long id) {
        Optional<Tratamento> tratamentoOpt = tratamentoRepository.findById(id);
        if (tratamentoOpt.isEmpty()) {
            logger.error("Erro: Tentativa de deletar tratamento inexistente (ID={})", id);
            throw new RuntimeException("Tratamento não encontrado.");
        }

        try {
            Tratamento tratamento = tratamentoOpt.get();
            logger.info("Tentando excluir tratamento com ID={}", id);
            tratamentoRepository.deleteById(id);
            tratamentoRepository.flush();

            tratamentoProducer.enviarExclusao(tratamento);

            logger.info("Tratamento com ID={} excluído com sucesso.", id);
        } catch (Exception e) {
            logger.error("Erro ao excluir tratamento ID={}: {}", id, e.getMessage());
            throw new RuntimeException("Erro ao excluir tratamento.");
        }
    }
}

