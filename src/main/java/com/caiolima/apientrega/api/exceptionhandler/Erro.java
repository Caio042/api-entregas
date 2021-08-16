package com.caiolima.apientrega.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Erro {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    List<CampoIncorreto> campos;
}
