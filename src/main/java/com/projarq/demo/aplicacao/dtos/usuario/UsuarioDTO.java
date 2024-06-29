package com.projarq.demo.aplicacao.dtos.usuario;

import com.projarq.demo.domain.entity.Usuario;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class UsuarioDTO {

    private String usuario;
    private String senha;

}
