package com.example.Odontoprev.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BAIRRO_PACIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BAIRRO_PACIENTE")
    @SequenceGenerator(name = "SEQ_BAIRRO_PACIENTE", sequenceName = "SEQ_BAIRRO_PACIENTE", allocationSize = 1)
    @Column(name = "ID_BAIRRO")
    private Long id;

    @Column(name = "NOME_BAIRRO", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_CIDADE")
    private Cidade cidade;
}
