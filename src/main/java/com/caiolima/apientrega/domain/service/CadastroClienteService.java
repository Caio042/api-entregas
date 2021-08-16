package com.caiolima.apientrega.domain.service;

import com.caiolima.apientrega.domain.exception.NegocioException;
import com.caiolima.apientrega.domain.model.Cliente;
import com.caiolima.apientrega.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CadastroClienteService {

    private ClienteRepository repository;

    @Transactional //declara que o metodo deve ser executado dentro de uma transação
    //se algo no metódo der errado todas as transações que estão sendo feito no banco de dados são descartadas
    public Cliente salvar (Cliente cliente){
        boolean emailEmUso = repository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clientedb -> !clientedb.equals(cliente));

        if (emailEmUso){
            throw new NegocioException("email em uso");
        }

        return repository.save(cliente);
    }

    @Transactional
    public void deletar(Long id){
        repository.deleteById(id);
    }
}