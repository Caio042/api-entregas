package com.caiolima.apientrega.api.controller;

import com.caiolima.apientrega.domain.model.Entrega;
import com.caiolima.apientrega.domain.service.CriacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping ("/entregas")
@AllArgsConstructor
public class EntregaController {

    private CriacaoEntregaService service;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Entrega solicitarEntrega (@RequestBody @Valid Entrega entrega){
        return service.solicitar(entrega);
    }
}
