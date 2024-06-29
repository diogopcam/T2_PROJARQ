package com.projarq.demo.aplicacao.casosDeUso.assinatura;

import com.projarq.demo.aplicacao.dtos.assinatura.ListaAssinaturaDTO;
import com.projarq.demo.domain.entity.Assinatura;
import com.projarq.demo.domain.services.ServicoAssinatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaAssinaturas {

    @Autowired
    private ServicoAssinatura servicoAssinatura;

    public List<ListaAssinaturaDTO> listaAssinaturasApp(long codapp) {
        return servicoAssinatura.listaAssinaturasApp(codapp);
    }

    public List<ListaAssinaturaDTO> listaAssinaturasCliente(long codcli) {
        return servicoAssinatura.listaAssinaturasCliente(codcli);
    }

    public List<ListaAssinaturaDTO> getAssinaturas(String tipo) {
        return servicoAssinatura.getAssinaturas(tipo);
    }
}
