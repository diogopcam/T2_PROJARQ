package com.projarq.demo.aplicacao.dtos.cliente;

import com.projarq.demo.domain.entity.Cliente;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class ClienteDTO {
    private long codigo;
    private String nome;
    private String email;
}
