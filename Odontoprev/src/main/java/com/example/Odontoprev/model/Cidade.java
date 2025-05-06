package com.example.Odontoprev.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "CIDADE_PACIENTE")
@Getter
@Setter
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CIDADE_PACIENTE")
    @SequenceGenerator(name = "SEQ_CIDADE_PACIENTE", sequenceName = "SEQ_CIDADE_PACIENTE", allocationSize = 1)
    @Column(name = "ID_CIDADE")
    private Long id;

    @Column(name = "NOME_CIDADE", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

    public Cidade() {}

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }
}
