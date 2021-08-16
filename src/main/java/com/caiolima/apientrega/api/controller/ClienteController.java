package com.caiolima.apientrega.api.controller;

import com.caiolima.apientrega.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;



@RestController
@RequestMapping ("/clientes")
public class ClienteController {

    @PersistenceContext // injeção de dependencia, tipo um autowired
    private EntityManager manager; //faz operações no banco de dados

    @GetMapping
    public List<Cliente> consultar(){
        return manager.createQuery("from Cliente", Cliente.class) //linguagem jpql
                .getResultList();
    }
}