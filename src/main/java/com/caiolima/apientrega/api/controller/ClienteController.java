package com.caiolima.apientrega.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.caiolima.apientrega.domain.model.Cliente;
import com.caiolima.apientrega.domain.repository.ClienteRepository;

@RestController
@RequestMapping ("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> consultarTodos(){
        return repository.findAll();
    }
}