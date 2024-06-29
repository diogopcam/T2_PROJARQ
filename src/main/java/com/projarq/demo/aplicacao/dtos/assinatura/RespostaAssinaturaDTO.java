package com.projarq.demo.aplicacao.dtos.assinatura;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaAssinaturaDTO {
    private long codigoAssinatura;
    private long codigoCliente;
    private long codigoAplicativo;
    private Date dataInicio;
    private Date dataEncerramento;
}