package com.caiolima.apientrega.domain.service;

import com.caiolima.apientrega.domain.exception.NegocioException;
import com.caiolima.apientrega.domain.model.Cliente;
import com.caiolima.apientrega.domain.model.Entrega;
import com.caiolima.apientrega.domain.model.StatusEntrega;
import com.caiolima.apientrega.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CriacaoEntregaService {

    private EntregaRepository entregaRepository;

    private CadastroClienteService clienteService;

    @Transactional
    public Entrega solicitar (Entrega entrega){
        Cliente cliente = clienteService.buscarPorId(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());


        return entregaRepository.save(entrega);
    }
}
