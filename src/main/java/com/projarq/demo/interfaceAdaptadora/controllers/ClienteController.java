package com.projarq.demo.interfaceAdaptadora.controllers;

import com.projarq.demo.aplicacao.casosDeUso.cliente.CadastraCliente;
import com.projarq.demo.aplicacao.casosDeUso.cliente.ListaClientes;
import com.projarq.demo.aplicacao.dtos.cliente.CadastraClienteDTO;
import com.projarq.demo.aplicacao.dtos.cliente.ClienteDTO;
import com.projarq.demo.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/servcad/clientes")
@CrossOrigin("*")
@RestController
public class ClienteController {

    @Autowired
    private ListaClientes listaClientes;

    @Autowired
    private CadastraCliente cadastraCliente;

    @GetMapping
    public List<ClienteDTO> todos() {
        return listaClientes.todos();
    }

    @PostMapping
    public Cliente novoCliente(@RequestBody CadastraClienteDTO cliente) {
        return cadastraCliente.cadastraCliente(cliente);
    }
}
