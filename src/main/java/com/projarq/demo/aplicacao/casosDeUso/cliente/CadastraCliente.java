package com.projarq.demo.aplicacao.casosDeUso.cliente;

import com.projarq.demo.aplicacao.dtos.cliente.CadastraClienteDTO;
import com.projarq.demo.domain.entity.Cliente;
import com.projarq.demo.domain.services.ServicoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraCliente {

    @Autowired
    private ServicoCliente servicoCliente;

    public Cliente cadastraCliente(CadastraClienteDTO cliente) {
        return servicoCliente.cadastraCliente(cliente);
    }

}
