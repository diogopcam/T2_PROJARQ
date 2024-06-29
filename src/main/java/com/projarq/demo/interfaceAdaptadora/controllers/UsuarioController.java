package com.projarq.demo.interfaceAdaptadora.controllers;

import com.projarq.demo.aplicacao.casosDeUso.usuario.CadastraUsuario;
import com.projarq.demo.aplicacao.casosDeUso.usuario.ListaUsuarios;
import com.projarq.demo.aplicacao.dtos.usuario.CadastraUsuarioDTO;
import com.projarq.demo.aplicacao.dtos.usuario.UsuarioDTO;
import com.projarq.demo.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/servcad/usuarios")
@CrossOrigin("*")
@RestController
public class UsuarioController {

    @Autowired
    private ListaUsuarios listaUsuarios;

    @Autowired
    private CadastraUsuario cadastraUsuario;

    @GetMapping
    public List<UsuarioDTO> todos() {
        return listaUsuarios.todos();
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody CadastraUsuarioDTO usuario) {
        return cadastraUsuario.cadastraUsuario(usuario);
    }
}
