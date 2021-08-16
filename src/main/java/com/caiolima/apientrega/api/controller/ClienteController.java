package com.caiolima.apientrega.api.controller;

import com.caiolima.apientrega.domain.service.CadastroClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.caiolima.apientrega.domain.model.Cliente;
import com.caiolima.apientrega.domain.repository.ClienteRepository;

import javax.validation.Valid;

@RestController
@RequestMapping ("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteRepository repository;
    private CadastroClienteService service;

    @GetMapping
    public List<Cliente> consultarTodos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> consultarPorId(@PathVariable Long id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED) // especificar qual o status retornar para a requisição
    public Cliente cadastrar(@Valid @RequestBody Cliente cliente){
        return service.salvar(cliente);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Cliente> atualizar (@Valid @PathVariable Long id, @RequestBody Cliente cliente){
        if (repository.existsById(id)){
            cliente.setId(id);
            return ResponseEntity.ok(service.salvar(cliente));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

        if (repository.existsById(id)){
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}