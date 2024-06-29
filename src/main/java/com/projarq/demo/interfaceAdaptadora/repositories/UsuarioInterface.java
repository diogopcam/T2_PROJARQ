package com.projarq.demo.interfaceAdaptadora.repositories;

import com.projarq.demo.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioInterface extends JpaRepository<Usuario, Long> {
}
