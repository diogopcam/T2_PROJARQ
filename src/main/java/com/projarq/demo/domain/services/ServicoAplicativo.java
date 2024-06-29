package com.projarq.demo.domain.services;

import com.projarq.demo.aplicacao.dtos.aplicativo.AplicativoDTO;
import com.projarq.demo.aplicacao.dtos.aplicativo.CadastraAplicativoDTO;
import com.projarq.demo.domain.entity.Aplicativo;
import com.projarq.demo.domain.repositories.IAplicativoRepositorio;
import com.projarq.demo.interfaceAdaptadora.repositories.AplicativoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoAplicativo implements IAplicativoRepositorio {
    @Autowired
    private AplicativoInterface repositorio;

    @Override
    public List<AplicativoDTO> todos() {
        return repositorio.findAll().stream().map(aplicativo -> new AplicativoDTO(
                aplicativo.getCodigo(),
                aplicativo.getNome(),
                aplicativo.getCustoMensal())).toList();
    }

    private final AplicativoInterface aplicativoInterface;

    @Autowired
    public ServicoAplicativo(AplicativoInterface aplicativoInterface) {
        this.aplicativoInterface = aplicativoInterface;
    }

    public Aplicativo salvarNovoAplicativo(CadastraAplicativoDTO dto) {
        if (dto.nome().isEmpty() || dto.custo() < 0) return null;
        else return aplicativoInterface.save(new Aplicativo(dto));
    }
}
