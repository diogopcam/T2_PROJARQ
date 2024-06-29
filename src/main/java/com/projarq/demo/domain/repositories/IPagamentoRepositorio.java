package com.projarq.demo.domain.repositories;

import com.projarq.demo.aplicacao.dtos.pagamento.RegistraPagamentoDTO;
import com.projarq.demo.aplicacao.dtos.pagamento.RespostaRegistraPagamentoDTO;

public interface IPagamentoRepositorio {
    RespostaRegistraPagamentoDTO registraPagamento(RegistraPagamentoDTO registraPagamentoDTO);

}
