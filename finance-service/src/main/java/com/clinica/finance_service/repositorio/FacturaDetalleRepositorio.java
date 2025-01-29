package com.clinica.finance_service.repositorio;

import com.clinica.finance_service.modelo.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaDetalleRepositorio extends JpaRepository<FacturaDetalle, Long> {
}
