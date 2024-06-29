package com.projarq.demo.interfaceAdaptadora.controllers;

import com.projarq.demo.aplicacao.casosDeUso.pagamento.RegistraPagamento;
import com.projarq.demo.aplicacao.dtos.pagamento.RegistraPagamentoDTO;
import com.projarq.demo.aplicacao.dtos.pagamento.RespostaRegistraPagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@CrossOrigin("*")
@RestController
public class PagamentoController {

    @Autowired
    private RegistraPagamento registraPagamento;

    @PostMapping("/registrarpagamento")
    public RespostaRegistraPagamentoDTO registraPagamento(@RequestBody RegistraPagamentoDTO registraPagamentoDTO) {
        return registraPagamento.registraPagamento(registraPagamentoDTO);
    }
}
