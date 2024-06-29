package com.projarq.demo.domain.services;

import com.projarq.demo.aplicacao.dtos.pagamento.RegistraPagamentoDTO;
import com.projarq.demo.aplicacao.dtos.pagamento.RespostaRegistraPagamentoDTO;
import com.projarq.demo.domain.entity.Assinatura;
import com.projarq.demo.domain.entity.Pagamento;
import com.projarq.demo.domain.repositories.IPagamentoRepositorio;
import com.projarq.demo.interfaceAdaptadora.repositories.AssinaturaInterface;
import com.projarq.demo.interfaceAdaptadora.repositories.ClienteInterface;
import com.projarq.demo.interfaceAdaptadora.repositories.PagamentoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class ServicoPagamento implements IPagamentoRepositorio {

    @Autowired
    private PagamentoInterface repository;

    @Autowired
    private AssinaturaInterface assinaturaRepository;

    public RespostaRegistraPagamentoDTO registraPagamento(RegistraPagamentoDTO registraPagamentoDTO){

        RespostaRegistraPagamentoDTO respostaRegistraPagamentoDTO = new RespostaRegistraPagamentoDTO();

        Optional<Assinatura> assinatura = assinaturaRepository.findById(registraPagamentoDTO.codass());

        // Verificação caso a assinatura não exista e para ver se o valor é maior que o valor do custo mensal
        if(assinatura.isEmpty()){
            System.out.println("não existe assinatura");
            return null;
        } else if (assinatura.get().getAplicativo().getCustoMensal() > registraPagamentoDTO.valorPago()){
            System.out.println("valor errado");
            respostaRegistraPagamentoDTO.setStatus("VALOR_INCORRETO");
            respostaRegistraPagamentoDTO.setValor(registraPagamentoDTO.valorPago());
            respostaRegistraPagamentoDTO.setData(assinatura.get().getFimVigencia());
            return respostaRegistraPagamentoDTO;
        }

        respostaRegistraPagamentoDTO.setStatus("PAGAMENTO_OK");

        Calendar calendario = Calendar.getInstance();

        Date fimVirgencia = assinatura.get().getFimVigencia();
        Date hoje = new Date();

        if(fimVirgencia.before(hoje)){
            calendario.setTime(hoje);
        } else {
            calendario.setTime(fimVirgencia);
        }
        calendario.add(Calendar.DAY_OF_YEAR, 30);

        Date novaData = calendario.getTime();
        respostaRegistraPagamentoDTO.setData(novaData);
        respostaRegistraPagamentoDTO.setValor(0);

        Assinatura assinaturaPagamento = assinatura.orElseThrow(() -> new RuntimeException("Assinatura não encontrada"));

        assinaturaRepository.findById(registraPagamentoDTO.codass()).get().setFimVigencia(novaData);
        repository.save(new Pagamento(assinaturaPagamento, registraPagamentoDTO.valorPago(), registraPagamentoDTO.dataPagamento(), ""));

        return respostaRegistraPagamentoDTO;
    }

}
