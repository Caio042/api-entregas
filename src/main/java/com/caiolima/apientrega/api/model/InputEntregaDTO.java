package com.caiolima.apientrega.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class InputEntregaDTO {

    @Valid
    @NotNull
    private ClienteIdInputDTO clienteId;

    @Valid
    @NotNull
    private DestinatarioDTO destinatario;

    @NotNull
    @Min(0)
    private BigDecimal taxa;
}
