package com.projarq.demo.domain.entity;

import com.projarq.demo.aplicacao.dtos.usuario.CadastraUsuarioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private String usuario;
    private String senha;

    public Usuario(CadastraUsuarioDTO usuario) {
        this.usuario = usuario.usuario();
        this.senha = usuario.senha();
    }
}
