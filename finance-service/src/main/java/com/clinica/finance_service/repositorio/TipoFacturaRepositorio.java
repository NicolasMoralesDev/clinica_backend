package com.clinica.finance_service.repositorio;

import com.clinica.finance_service.modelo.TipoFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFacturaRepositorio extends JpaRepository<TipoFactura, Long> {
}
