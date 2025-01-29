package com.clinica.finance_service.repositorio;

import com.clinica.finance_service.modelo.MedioDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioDePagoRepositorio extends JpaRepository<MedioDePago, Long> {
}
