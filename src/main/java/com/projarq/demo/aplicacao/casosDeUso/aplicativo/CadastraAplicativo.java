package com.projarq.demo.aplicacao.casosDeUso.aplicativo;

import com.projarq.demo.aplicacao.dtos.aplicativo.CadastraAplicativoDTO;
import com.projarq.demo.domain.entity.Aplicativo;

public interface CadastraAplicativo {
    Aplicativo cadastrarAplicativo(CadastraAplicativoDTO dto);
}
