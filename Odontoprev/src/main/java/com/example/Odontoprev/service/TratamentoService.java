package com.example.Odontoprev.service;

import org.springframework.jdbc.core.JdbcTemplate;
import com.example.Odontoprev.model.Tratamento;
import com.example.Odontoprev.repository.TratamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TratamentoService {

    @Autowired
    private TratamentoRepository tratamentoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(TratamentoService.class);

    public List<Tratamento> listarTodos() {
        return tratamentoRepository.findAll();
    }

    public Optional<Tratamento> buscarPorId(Long id) {
        return tratamentoRepository.findById(id);
    }

    public Tratamento salvar(Tratamento tratamento) {
        logger.info("Salvando tratamento: Descrição={}, Tipo={}, Custo={}",
                tratamento.getDescricao(), tratamento.getTipo(), tratamento.getCusto());

        if (tratamento.getDescricao() == null || tratamento.getTipo() == null || tratamento.getCusto() == null) {
            logger.error("Erro: Campos obrigatórios não preenchidos!");
            throw new IllegalArgumentException("Todos os campos são obrigatórios.");
        }

        return tratamentoRepository.save(tratamento);
    }

    @Transactional
    public void deletar(Long id) {
        if (tratamentoRepository.existsById(id)) {
            try {
                System.out.println("Excluindo tratamento com ID: " + id);
                logger.info("Tentando excluir tratamento com ID={}", id);

                tratamentoRepository.deleteById(id);
                tratamentoRepository.flush();

                logger.info("Tratamento com ID={} excluído com sucesso.", id);
            } catch (Exception e) {
                logger.error("Erro ao excluir tratamento ID={}: {}", id, e.getMessage());
                throw new RuntimeException("Erro ao excluir tratamento.");
            }
        } else {
            logger.error("Erro: Tentativa de deletar um tratamento inexistente (ID={})", id);
            throw new RuntimeException("Tratamento não encontrado.");
        }
    }

}
