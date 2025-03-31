package com.clinica.finance_service.repositorio;

import com.clinica.finance_service.modelo.Factura;
import com.clinica.finance_service.modelo.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaDetalleRepositorio extends JpaRepository<FacturaDetalle, Long> {
    List<FacturaDetalle> findByFactura(Factura factura);
}
