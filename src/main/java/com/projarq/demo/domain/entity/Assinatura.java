package com.projarq.demo.domain.entity;

import com.projarq.demo.aplicacao.dtos.assinatura.AssinaturaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @ManyToOne
    private Aplicativo aplicativo;
    @ManyToOne
    private Cliente cliente;
    private Date inicioVigencia;
    private Date fimVigencia;

    public Assinatura(AssinaturaDTO assinatura) {
        this.aplicativo = assinatura.getAplicativo();
        this.cliente = assinatura.getCliente();
        this.inicioVigencia = assinatura.getInicioVigencia();
        this.fimVigencia = assinatura.getFimVigencia();
    }
}
