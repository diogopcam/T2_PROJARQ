package com.projarq.demo.aplicacao.dtos.assinatura;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class ListaAssinaturaDTO {
    private long codigoAssinatura;
    private long codigoCliente;
    private long codigoAplicativo;
    private Date dataInicio;
    private Date dataFim;
    private String status;
}