package com.example.Odontoprev.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRATAMENTO")
@SequenceGenerator(name = "SEQ_TRATAMENTO", sequenceName = "SEQ_TRATAMENTO", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRATAMENTO")
    @Column(name = "ID_TRATAMENTO")
    private Long id;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "CUSTO", nullable = false)
    private Double custo;
}
