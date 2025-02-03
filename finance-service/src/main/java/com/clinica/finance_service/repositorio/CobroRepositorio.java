package com.clinica.finance_service.repositorio;

import com.clinica.finance_service.modelo.Cobro;
import com.clinica.finance_service.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CobroRepositorio extends JpaRepository<Cobro, Long> {

    List<Cobro> findByFactura(Factura factura);
}
