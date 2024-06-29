package com.projarq.demo.domain.repositories;

import com.projarq.demo.aplicacao.dtos.aplicativo.AplicativoDTO;
import com.projarq.demo.aplicacao.dtos.aplicativo.CadastraAplicativoDTO;
import com.projarq.demo.domain.entity.Aplicativo;

import java.util.List;

public interface IAplicativoRepositorio {
    List<AplicativoDTO> todos();

    Aplicativo salvarNovoAplicativo(CadastraAplicativoDTO dto);
}
