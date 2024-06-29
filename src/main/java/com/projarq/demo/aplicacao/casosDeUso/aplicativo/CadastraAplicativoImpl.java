// Implementação do Caso de Uso
package com.projarq.demo.aplicacao.casosDeUso.aplicativo;

import com.projarq.demo.aplicacao.dtos.aplicativo.AplicativoDTO;
import com.projarq.demo.aplicacao.dtos.aplicativo.CadastraAplicativoDTO;
import com.projarq.demo.domain.entity.Aplicativo;
import com.projarq.demo.domain.repositories.IAplicativoRepositorio;
import com.projarq.demo.domain.services.ServicoAplicativo;
import com.projarq.demo.interfaceAdaptadora.repositories.AplicativoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CadastraAplicativoImpl {

    @Autowired
    ServicoAplicativo servicoAplicativo;

    public Aplicativo cadastrarAplicativo(CadastraAplicativoDTO dto) {
        return servicoAplicativo.salvarNovoAplicativo(dto);
    }
}