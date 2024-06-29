package com.projarq.demo.aplicacao.dtos.pagamento;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaRegistraPagamentoDTO{
    private String status;
    private Date data;
    private float valor;
}
