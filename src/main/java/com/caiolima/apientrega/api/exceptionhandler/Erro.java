package com.caiolima.apientrega.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude (JsonInclude.Include.NON_NULL) // só irá no json campos não nulos
public class Erro {

    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    List<CampoIncorreto> campos;
}
