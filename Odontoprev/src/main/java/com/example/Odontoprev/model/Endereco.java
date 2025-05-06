package com.example.Odontoprev.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "ENDERECO_PACIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENDERECO")
    @SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(name = "CEP", nullable = false, length = 10)
    private String cep;

    @Column(name = "NUMERO", nullable = false, length = 10)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "ID_BAIRRO", referencedColumnName = "ID_BAIRRO", nullable = false)
    private Bairro bairro;
}
