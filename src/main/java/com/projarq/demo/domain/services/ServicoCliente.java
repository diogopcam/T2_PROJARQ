package com.projarq.demo.domain.services;

import com.projarq.demo.aplicacao.dtos.cliente.CadastraClienteDTO;
import com.projarq.demo.aplicacao.dtos.cliente.ClienteDTO;
import com.projarq.demo.domain.entity.Cliente;
import com.projarq.demo.domain.repositories.IClienteRepositorio;
import com.projarq.demo.interfaceAdaptadora.repositories.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoCliente implements IClienteRepositorio {

    @Autowired
    private ClienteInterface repositorio;

    public List<ClienteDTO> todos() {
        return repositorio.findAll()
                .stream()
                .map(cliente -> ClienteDTO.builder()
                        .codigo(cliente.getCodigo())
                        .email(cliente.getEmail())
                        .nome(cliente.getNome())
                        .build()
                )
                .toList();
    }

    public Cliente cadastraCliente(CadastraClienteDTO cliente) {
        // Verifica se existe algum email cadastrado com o email do cliente a
        // ser cadastrado e verifica se o email contem @
        if (repositorio.findAll().stream()
                .anyMatch(clientes -> clientes.getEmail().equals(cliente.email()))) {
            return null;
        } else if (cliente.nome().isEmpty()) {
            return null;
        } else if (cliente.email().contains("@")) {
            return repositorio.save(new Cliente(cliente));
        }
        return null;
    }

}
