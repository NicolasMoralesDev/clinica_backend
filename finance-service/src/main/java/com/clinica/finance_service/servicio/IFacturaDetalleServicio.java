package com.clinica.finance_service.servicio;


import com.clinica.finance_service.dto.FacturaDetalleDTO;
import com.clinica.finance_service.modelo.FacturaDetalle;

import java.util.List;

public interface IFacturaDetalleServicio {

    List<FacturaDetalle> listarTodos();
    FacturaDetalle obtenerPorId();
    FacturaDetalle crear(FacturaDetalleDTO dto);
    FacturaDetalle actualizar(Long id, FacturaDetalleDTO dto);
    void eliminar(Long id);


}
