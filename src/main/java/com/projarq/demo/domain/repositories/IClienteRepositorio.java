package com.projarq.demo.domain.repositories;

import com.projarq.demo.aplicacao.dtos.cliente.CadastraClienteDTO;
import com.projarq.demo.aplicacao.dtos.cliente.ClienteDTO;
import com.projarq.demo.domain.entity.Cliente;

import java.util.List;

public interface IClienteRepositorio {
    List<ClienteDTO> todos();

    Cliente cadastraCliente(CadastraClienteDTO cliente);
}
