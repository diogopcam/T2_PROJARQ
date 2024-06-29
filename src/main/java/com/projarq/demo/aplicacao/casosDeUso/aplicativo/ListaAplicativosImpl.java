package com.projarq.demo.aplicacao.casosDeUso.aplicativo;

import com.projarq.demo.aplicacao.dtos.aplicativo.AplicativoDTO;
import com.projarq.demo.domain.repositories.IAplicativoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListaAplicativosImpl implements ListaAplicativos {

    private final IAplicativoRepositorio repositorio;

    @Override
    public List<AplicativoDTO> listaAplicativos() {
        return repositorio.todos();
    }
}