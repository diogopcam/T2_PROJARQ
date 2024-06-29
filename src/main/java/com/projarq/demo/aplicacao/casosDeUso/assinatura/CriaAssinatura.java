package com.projarq.demo.aplicacao.casosDeUso.assinatura;

import com.projarq.demo.aplicacao.dtos.assinatura.CriaAssinaturaDTO;
import com.projarq.demo.aplicacao.dtos.assinatura.RespostaAssinaturaDTO;
import com.projarq.demo.domain.services.ServicoAssinatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriaAssinatura {

    @Autowired
    private ServicoAssinatura servicoAssinatura;

    public RespostaAssinaturaDTO criaAssinatura(CriaAssinaturaDTO criaAssinaturaDTO) {
        return servicoAssinatura.criaAssinatura(criaAssinaturaDTO);
    }
}
