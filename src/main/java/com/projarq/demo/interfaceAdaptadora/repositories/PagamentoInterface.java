package com.projarq.demo.interfaceAdaptadora.repositories;

import com.projarq.demo.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoInterface extends JpaRepository<Pagamento, Long> {
}
