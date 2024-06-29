package com.projarq.demo.aplicacao.casosDeUso.usuario;

import com.projarq.demo.aplicacao.dtos.usuario.CadastraUsuarioDTO;
import com.projarq.demo.domain.entity.Usuario;
import com.projarq.demo.domain.services.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CadastraUsuario {

    @Autowired
    private ServicoUsuario servicoUsuario;

    public Usuario cadastraUsuario(CadastraUsuarioDTO usuario){
        return servicoUsuario.cadastraUsuario(usuario);
    }

}
