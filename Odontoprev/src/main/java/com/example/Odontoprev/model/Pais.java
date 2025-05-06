package com.example.Odontoprev.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "PAIS_PACIENTE")
@Getter
@Setter
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAIS_PACIENTE")
    @SequenceGenerator(name = "SEQ_PAIS_PACIENTE", sequenceName = "SEQ_PAIS_PACIENTE", allocationSize = 1)
    @Column(name = "ID_PAIS")
    private Long id;

    @Column(name = "NOME_PAIS", nullable = false)
    private String nome;

    public Pais() {}

    public Pais(String nome) {
        this.nome = nome;
    }
}
