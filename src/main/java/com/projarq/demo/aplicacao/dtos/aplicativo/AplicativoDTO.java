package com.projarq.demo.aplicacao.dtos.aplicativo;

import com.projarq.demo.domain.entity.Aplicativo;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class AplicativoDTO {
    private long codigo;
    private String nome;
    private float custoMensal;
}

