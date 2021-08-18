package com.caiolima.apientrega.api.controller;

import com.caiolima.apientrega.api.model.EntregaDTO;
import com.caiolima.apientrega.api.model.InputEntregaDTO;
import com.caiolima.apientrega.api.serializer.EntregaSerializer;
import com.caiolima.apientrega.domain.model.Entrega;
import com.caiolima.apientrega.domain.repository.EntregaRepository;
import com.caiolima.apientrega.domain.service.CriacaoEntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private EntregaSerializer serializer;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public EntregaDTO solicitarEntrega (@RequestBody @Valid InputEntregaDTO entregaInput){

        Entrega entregaSolicitada = serializer.toModel(entregaInput);
        entregaSolicitada = service.solicitar(entregaSolicitada);
        return serializer.toDto(entregaSolicitada);
    }

    @GetMapping
    public List<Entrega> listarEntregas(){
        return repository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<EntregaDTO> buscarPorId(@PathVariable Long id){
        return repository.findById(id)
                .map(entrega -> ResponseEntity.ok(serializer.toDto(entrega)))
                .orElse(ResponseEntity.notFound().build());


    }
}
