package com.projarq.demo.domain.entity;

import com.projarq.demo.aplicacao.dtos.cliente.CadastraClienteDTO;
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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String nome;
    private String email;

    public Cliente(CadastraClienteDTO cliente) {
        this.nome = cliente.nome();
        this.email = cliente.email();
    }
}
