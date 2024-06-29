package com.projarq.demo.interfaceAdaptadora.repositories;

import com.projarq.demo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteInterface extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}
