package com.projarq.demo.interfaceAdaptadora.repositories;

import com.projarq.demo.domain.entity.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AplicativoInterface extends JpaRepository<Aplicativo, Long> {

}
