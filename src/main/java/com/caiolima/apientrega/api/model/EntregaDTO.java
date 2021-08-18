package com.caiolima.apientrega.api.model;

import com.caiolima.apientrega.domain.model.Cliente;
import com.caiolima.apientrega.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaDTO {

    private Long id;

    private ClienteDTO cliente;

    private DestinatarioDTO destinatario;

    private BigDecimal taxa;

    private StatusEntrega status;

    private OffsetDateTime dataPedido;

    private OffsetDateTime dataFinalizacao;
}
