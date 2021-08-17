package com.caiolima.apientrega.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name = "tb_entrega")
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @Embedded //estará em outra classe, mas suas colunas ficarão na tabela de entrega
    private Destinatario destinatario;

    private BigDecimal taxa;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    private LocalDateTime dataPedido;

    private LocalDateTime dataFinalizacao;
}
