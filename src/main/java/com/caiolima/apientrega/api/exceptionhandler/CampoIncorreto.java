package com.caiolima.apientrega.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CampoIncorreto {
    
    private String campo;
    private String mensagem;
}
