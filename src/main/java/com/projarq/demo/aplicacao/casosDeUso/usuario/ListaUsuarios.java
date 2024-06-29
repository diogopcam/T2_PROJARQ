package com.projarq.demo.aplicacao.casosDeUso.usuario;

import com.projarq.demo.aplicacao.dtos.usuario.UsuarioDTO;
import com.projarq.demo.domain.services.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaUsuarios {

    @Autowired
    private ServicoUsuario servicoUsuario;

    public List<UsuarioDTO> todos() {
        return servicoUsuario.todos();
    }
}
