package com.projarq.demo.aplicacao.casosDeUso.assinatura;

import com.projarq.demo.domain.services.ServicoAssinatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificaStatus {

    @Autowired
    private ServicoAssinatura servicoAssinatura;

    public boolean verificaStatusAssinatura(long codass) {
        return servicoAssinatura.verificaStatusAssinatura(codass);
    }
}
