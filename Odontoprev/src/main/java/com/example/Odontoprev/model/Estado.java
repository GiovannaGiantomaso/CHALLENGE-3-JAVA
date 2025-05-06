package com.example.Odontoprev.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "ESTADO_PACIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADO_PACIENTE")
    @SequenceGenerator(name = "SEQ_ESTADO_PACIENTE", sequenceName = "SEQ_ESTADO_PACIENTE", allocationSize = 1)
    @Column(name = "ID_ESTADO")
    private Long id;

    @Column(name = "NOME_ESTADO", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS")
    private Pais pais;
}
