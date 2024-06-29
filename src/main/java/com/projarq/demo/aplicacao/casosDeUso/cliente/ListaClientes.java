package com.projarq.demo.aplicacao.casosDeUso.cliente;

import com.projarq.demo.aplicacao.dtos.cliente.ClienteDTO;
import com.projarq.demo.domain.services.ServicoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaClientes {

    @Autowired
    private ServicoCliente servicoCliente;

    public List<ClienteDTO> todos() {
        return servicoCliente.todos();
    }
}
