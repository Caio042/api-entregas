package com.caiolima.apientrega.domain.repository;

import com.caiolima.apientrega.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
