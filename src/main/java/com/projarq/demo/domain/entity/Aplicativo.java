package com.projarq.demo.domain.entity;

import com.projarq.demo.aplicacao.dtos.aplicativo.CadastraAplicativoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String nome;
    private float custoMensal;

    public Aplicativo(CadastraAplicativoDTO aplicativo) {
        this.nome = aplicativo.nome();
        this.custoMensal = aplicativo.custo();
    }
}
