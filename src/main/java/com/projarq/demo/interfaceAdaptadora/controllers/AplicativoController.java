package com.projarq.demo.interfaceAdaptadora.controllers;

import com.projarq.demo.aplicacao.casosDeUso.aplicativo.CadastraAplicativoImpl;
import com.projarq.demo.aplicacao.casosDeUso.aplicativo.ListaAplicativos;
import com.projarq.demo.aplicacao.casosDeUso.aplicativo.AtualizaCusto;
import com.projarq.demo.aplicacao.dtos.aplicativo.AplicativoDTO;
import com.projarq.demo.aplicacao.dtos.aplicativo.CadastraAplicativoDTO;
import com.projarq.demo.domain.entity.Aplicativo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/servcad")
public class AplicativoController {

    private final ListaAplicativos listaAplicativos;
    private final AtualizaCusto atualizaCustoAplicativo;
    private final CadastraAplicativoImpl cadastraAplicativo;

    @Autowired
    public AplicativoController(ListaAplicativos listaAplicativos, AtualizaCusto atualizaCustoAplicativo, CadastraAplicativoImpl cadastraAplicativo) {
        this.listaAplicativos = listaAplicativos;
        this.atualizaCustoAplicativo = atualizaCustoAplicativo;
        this.cadastraAplicativo = cadastraAplicativo;
    }

    @PostMapping("/aplicativos")
    public Aplicativo cadastraAplicativo(@RequestBody CadastraAplicativoDTO dto) {
        return cadastraAplicativo.cadastrarAplicativo(dto);
    }

    @GetMapping("/aplicativos")
    public List<AplicativoDTO> listarAplicativos() {
        return listaAplicativos.listaAplicativos();
    }

    @PostMapping("/aplicativos/atualizacusto/{codigo}")
    public ResponseEntity<AplicativoDTO> atualizarCustoAplicativo(@PathVariable long codigo, @RequestBody float custo) {
        AplicativoDTO aplicativoAtualizado = atualizaCustoAplicativo.atualizaCusto(codigo, custo);
        return ResponseEntity.status(HttpStatus.OK).body(aplicativoAtualizado);
    }
}