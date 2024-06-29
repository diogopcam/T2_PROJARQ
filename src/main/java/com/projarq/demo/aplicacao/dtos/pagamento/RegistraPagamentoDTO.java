package com.projarq.demo.aplicacao.dtos.pagamento;

import java.util.Date;

public record RegistraPagamentoDTO(
        Date dataPagamento,
        long codass,
        float valorPago
) {
}
