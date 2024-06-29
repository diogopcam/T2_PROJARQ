package com.projarq.demo.aplicacao.casosDeUso.aplicativo;

import com.projarq.demo.aplicacao.dtos.aplicativo.AplicativoDTO;

public interface AtualizaCusto {
    AplicativoDTO atualizaCusto(long codigo, float custo);
}
