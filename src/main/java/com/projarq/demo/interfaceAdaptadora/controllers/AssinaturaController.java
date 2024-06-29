package com.projarq.demo.interfaceAdaptadora.controllers;

import com.projarq.demo.aplicacao.casosDeUso.assinatura.CriaAssinatura;
import com.projarq.demo.aplicacao.casosDeUso.assinatura.ListaAssinaturas;
import com.projarq.demo.aplicacao.casosDeUso.assinatura.VerificaStatus;
import com.projarq.demo.aplicacao.dtos.assinatura.CriaAssinaturaDTO;
import com.projarq.demo.aplicacao.dtos.assinatura.ListaAssinaturaDTO;
import com.projarq.demo.aplicacao.dtos.assinatura.RespostaAssinaturaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/servcad")
public class AssinaturaController {

    @Autowired
    private CriaAssinatura criaAssinatura;

    @Autowired
    private ListaAssinaturas listaAssinaturas;

    @Autowired
    private VerificaStatus verificaStatus;

    @PostMapping("/assinaturas")
    public RespostaAssinaturaDTO criaAssinatura(@RequestBody CriaAssinaturaDTO criaAssinaturaDTO) {
        return criaAssinatura.criaAssinatura(criaAssinaturaDTO);
    }

    @GetMapping("/assapp/{codapp}")
    public List<ListaAssinaturaDTO> listaAssinaturaApp(@PathVariable long codapp) {
        return listaAssinaturas.listaAssinaturasApp(codapp);
    }

    @GetMapping("/asscli/{codcli}")
    public List<ListaAssinaturaDTO> listaAssinaturaCliente(@PathVariable long codcli) {
        return listaAssinaturas.listaAssinaturasCliente(codcli);
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean verificaStatusAssinatura(@PathVariable long codass) {
        return verificaStatus.verificaStatusAssinatura(codass);
    }

    @GetMapping("/assinaturas/{tipo}")
    public List<ListaAssinaturaDTO> getAssinaturas(@PathVariable String tipo) {
        if (tipo.equals("TODAS") || tipo.equals("ATIVAS") || tipo.equals("CANCELADAS")) {
            return listaAssinaturas.getAssinaturas(tipo);
        }
        System.out.println("opção invalida");
        return null;
    }
}
