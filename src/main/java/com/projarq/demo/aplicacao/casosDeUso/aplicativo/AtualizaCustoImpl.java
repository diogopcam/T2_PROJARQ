package com.projarq.demo.aplicacao.casosDeUso.aplicativo;

import com.projarq.demo.aplicacao.dtos.aplicativo.AplicativoDTO;
import com.projarq.demo.domain.entity.Aplicativo;
import com.projarq.demo.interfaceAdaptadora.repositories.AplicativoInterface;
import org.springframework.stereotype.Component;

@Component
public class AtualizaCustoImpl implements AtualizaCusto {
    private final AplicativoInterface repositorio;

    public AtualizaCustoImpl(AplicativoInterface repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public AplicativoDTO atualizaCusto(long idAplicativo, float novoCusto) {
        if (novoCusto < 0) return null;
        Aplicativo aplicativo = repositorio.findById(idAplicativo)
                .orElseThrow(() -> new RuntimeException("Aplicativo não encontrado"));

        aplicativo.setCustoMensal(novoCusto);

        repositorio.save(aplicativo);
        return new AplicativoDTO(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }
}