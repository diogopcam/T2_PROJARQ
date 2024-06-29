package com.projarq.demo.domain.services;

import com.projarq.demo.aplicacao.dtos.usuario.CadastraUsuarioDTO;
import com.projarq.demo.aplicacao.dtos.usuario.UsuarioDTO;
import com.projarq.demo.domain.entity.Usuario;
import com.projarq.demo.domain.repositories.IUsuarioRepositorio;
import com.projarq.demo.interfaceAdaptadora.repositories.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoUsuario implements IUsuarioRepositorio {

    @Autowired
    private UsuarioInterface repositorio;

    public List<UsuarioDTO> todos() {
        return repositorio.findAll()
                .stream()
                .map(usuario -> UsuarioDTO.builder()
                        .usuario(usuario.getUsuario())
                        .senha(usuario.getSenha())
                        .build()
                )
                .toList();
    }

    public Usuario cadastraUsuario(CadastraUsuarioDTO usuario) {
        List<Usuario> usuarios = repositorio.findAll();
        if (usuarios.size() == 1) return null;
        else return repositorio.save(new Usuario(usuario));
    }
}
