package com.clinica.finance_service.servicio;


import com.clinica.finance_service.DTO.FacturaDTO;
import com.clinica.finance_service.modelo.Factura;

import java.util.List;

public interface IFacturaServicio {

    List<Factura> listarTodos();
    Factura obtenerPorId(Long id);
    Factura crear(FacturaDTO dto);
    Factura actualizar(Long id, FacturaDTO dto);
    void eliminar(Long id);

}
