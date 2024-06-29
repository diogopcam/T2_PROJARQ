package com.projarq.demo.aplicacao.dtos.assinatura;

import com.projarq.demo.domain.entity.Aplicativo;
import com.projarq.demo.domain.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssinaturaDTO {

    private long codigo;
    private Aplicativo aplicativo;
    private Cliente cliente;
    private Date inicioVigencia;
    private Date fimVigencia;
}
