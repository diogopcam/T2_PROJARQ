package com.projarq.demo.aplicacao.casosDeUso.pagamento;

import com.projarq.demo.aplicacao.dtos.pagamento.RegistraPagamentoDTO;
import com.projarq.demo.aplicacao.dtos.pagamento.RespostaRegistraPagamentoDTO;
import com.projarq.demo.domain.services.ServicoPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistraPagamento {

    @Autowired
    private ServicoPagamento servicoPagamento;

    public RespostaRegistraPagamentoDTO registraPagamento(RegistraPagamentoDTO registraPagamentoDTO) {
        return servicoPagamento.registraPagamento(registraPagamentoDTO);
    }

}
