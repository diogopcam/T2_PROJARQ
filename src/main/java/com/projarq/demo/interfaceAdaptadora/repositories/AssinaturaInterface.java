package com.projarq.demo.interfaceAdaptadora.repositories;

import com.projarq.demo.domain.entity.Aplicativo;
import com.projarq.demo.domain.entity.Assinatura;
import com.projarq.demo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssinaturaInterface extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByAplicativo(Aplicativo aplicativo);

    List<Assinatura> findByCliente(Cliente cliente);
}
