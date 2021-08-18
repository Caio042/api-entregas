package com.caiolima.apientrega.api.controller;

import com.caiolima.apientrega.domain.model.Entrega;
import com.caiolima.apientrega.domain.repository.EntregaRepository;
import com.caiolima.apientrega.domain.service.CriacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/entregas")
@AllArgsConstructor
public class EntregaController {

    private CriacaoEntregaService service;
    private EntregaRepository repository;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Entrega solicitarEntrega (@RequestBody @Valid Entrega entrega){
        return service.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listarEntregas(){
        return repository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Entrega> buscarPorId(@PathVariable Long id){
        return repository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
