package com.projarq.demo.domain.repositories;

import com.projarq.demo.aplicacao.dtos.usuario.UsuarioDTO;
import com.projarq.demo.aplicacao.dtos.usuario.CadastraUsuarioDTO;
import com.projarq.demo.domain.entity.Usuario;

import java.util.List;

public interface IUsuarioRepositorio {
    List<UsuarioDTO> todos();

    Usuario cadastraUsuario(CadastraUsuarioDTO usuario);
}
