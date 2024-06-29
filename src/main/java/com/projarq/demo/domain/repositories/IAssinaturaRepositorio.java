package com.projarq.demo.domain.repositories;

import com.projarq.demo.aplicacao.dtos.assinatura.CriaAssinaturaDTO;
import com.projarq.demo.aplicacao.dtos.assinatura.ListaAssinaturaDTO;
import com.projarq.demo.aplicacao.dtos.assinatura.RespostaAssinaturaDTO;
import com.projarq.demo.domain.entity.Assinatura;

import java.util.Date;
import java.util.List;

public interface IAssinaturaRepositorio {
    RespostaAssinaturaDTO criaAssinatura(CriaAssinaturaDTO criaAssinaturaDTO);

    List<ListaAssinaturaDTO> listaAssinaturasApp(long codapp);

    List<ListaAssinaturaDTO> listaAssinaturasCliente(long codapp);

    boolean verificaStatusAssinatura(long codass);

    List<ListaAssinaturaDTO> getAssinaturas(String tipo);

    ListaAssinaturaDTO mapperDTO(Assinatura assinatura);

    String getStatus(Date fim);
}