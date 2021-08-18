package com.caiolima.apientrega.domain.model;

import com.caiolima.apientrega.domain.ValidationsGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
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

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationsGroup.ClientId.class) //converte de um validation group para outro
    @ManyToOne
    private Cliente cliente;

    private BigDecimal taxa;

    @JsonProperty (access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    @Embedded //estará em outra classe, mas suas colunas ficarão na tabela de entrega
    private Destinatario destinatario;

    @JsonProperty (access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataPedido;

    @JsonProperty (access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataFinalizacao;
}
