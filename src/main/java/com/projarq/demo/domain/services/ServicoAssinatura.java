package com.projarq.demo.domain.services;

import com.projarq.demo.aplicacao.dtos.assinatura.AssinaturaDTO;
import com.projarq.demo.aplicacao.dtos.assinatura.CriaAssinaturaDTO;
import com.projarq.demo.aplicacao.dtos.assinatura.ListaAssinaturaDTO;
import com.projarq.demo.aplicacao.dtos.assinatura.RespostaAssinaturaDTO;
import com.projarq.demo.domain.entity.Aplicativo;
import com.projarq.demo.domain.entity.Assinatura;
import com.projarq.demo.domain.entity.Cliente;
import com.projarq.demo.domain.repositories.IAssinaturaRepositorio;
import com.projarq.demo.interfaceAdaptadora.repositories.AplicativoInterface;
import com.projarq.demo.interfaceAdaptadora.repositories.AssinaturaInterface;
import com.projarq.demo.interfaceAdaptadora.repositories.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoAssinatura implements IAssinaturaRepositorio {

    @Autowired
    private AssinaturaInterface repository;

    @Autowired
    private ClienteInterface clienteRepository;

    @Autowired
    private AplicativoInterface aplicativoRepository;

    public RespostaAssinaturaDTO criaAssinatura(CriaAssinaturaDTO criaAssinaturaDTO) {
        if (clienteRepository.findById(criaAssinaturaDTO.codcli()).isEmpty() ||
                aplicativoRepository.findById(criaAssinaturaDTO.codapp()).isEmpty()) {
            System.out.println("cliente ou app, não encontrado");
            return null;
        } else System.out.println("cliente e app encontrados");

        AssinaturaDTO assinatura = new AssinaturaDTO();

        clienteRepository.findById(criaAssinaturaDTO
                        .codcli())
                .ifPresent(assinatura::setCliente);

        aplicativoRepository.findById(criaAssinaturaDTO
                        .codapp())
                .ifPresent(assinatura::setAplicativo);

        LocalDate dataAtual = LocalDate.now();

        assinatura.setInicioVigencia(Date.from(dataAtual.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        assinatura.setFimVigencia(Date.from(dataAtual.plusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant()));

        assinatura.setCodigo(repository.save(new Assinatura(assinatura)).getCodigo());

        return new RespostaAssinaturaDTO(
                assinatura.getCodigo(),
                assinatura.getCliente().getCodigo(),
                assinatura.getAplicativo().getCodigo(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia()
        );
    }

    public List<ListaAssinaturaDTO> listaAssinaturasApp(long codapp) {
        Aplicativo aplicativo = aplicativoRepository.findById(codapp).orElse(null);
        if (aplicativo != null) {
            return repository.findByAplicativo(aplicativo)
                    .stream()
                    .map(assinatura -> new ListaAssinaturaDTO(
                            assinatura.getCodigo(),
                            assinatura.getCliente().getCodigo(),
                            assinatura.getAplicativo().getCodigo(),
                            assinatura.getInicioVigencia(),
                            assinatura.getFimVigencia(),
                            getStatus(assinatura.getFimVigencia())
                    ))
                    .collect(Collectors.toList());
        } else return Collections.emptyList();
    }

    public List<ListaAssinaturaDTO> listaAssinaturasCliente(long codcli) {
        Cliente cliente = clienteRepository.findById(codcli).orElse(null);
        if (cliente != null) {
            return repository.findByCliente(cliente)
                    .stream()
                    .map(assinatura -> new ListaAssinaturaDTO(
                            assinatura.getCodigo(),
                            assinatura.getCliente().getCodigo(),
                            assinatura.getAplicativo().getCodigo(),
                            assinatura.getInicioVigencia(),
                            assinatura.getFimVigencia(),
                            getStatus(assinatura.getFimVigencia())
                    ))
                    .collect(Collectors.toList());
        } else return Collections.emptyList();
    }

    public boolean verificaStatusAssinatura(long codass) {
        Assinatura assinatura = repository.findById(codass).orElse(null);
        if (assinatura != null) {
            return getStatus(assinatura.getFimVigencia()).equals("ATIVA");
        }
        return false;
    }

    public List<ListaAssinaturaDTO> getAssinaturas(String tipo) {
        switch (tipo) {
            case "TODAS":
                return repository.findAll().stream().
                        map(this::mapperDTO).collect(Collectors.toList());
            case "ATIVAS":
                return repository.findAll().stream()
                        .filter(assinatura -> getStatus(assinatura.getFimVigencia()).equals("ATIVA"))
                        .map(this::mapperDTO).collect(Collectors.toList());
            case "CANCELADAS":
                return repository.findAll().stream()
                        .filter(assinatura -> getStatus(assinatura.getFimVigencia()).equals("CANCELADA"))
                        .map(this::mapperDTO).collect(Collectors.toList());
            default:
                return null;
        }
    }

    public ListaAssinaturaDTO mapperDTO(Assinatura assinatura) {
        return new ListaAssinaturaDTO(
                assinatura.getCodigo(),
                assinatura.getCliente().getCodigo(),
                assinatura.getAplicativo().getCodigo(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia(),
                getStatus(assinatura.getFimVigencia()));
    }

    public String getStatus(Date fim) {
        LocalDate dataFim = fim.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoje = LocalDate.now();

        if (dataFim.isBefore(hoje)) {
            return "CANCELADA";
        } else {
            return "ATIVA";
        }
    }
}
