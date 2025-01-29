package com.clinica.finance_service.servicio;

import com.clinica.finance_service.DTO.TipoFacturaDTO;
import com.clinica.finance_service.modelo.TipoFactura;

import java.util.List;

public interface ITipoFacturaServicio {

    List<TipoFactura> listarTodos();
    TipoFactura obtenerPorId(Long id);
    TipoFactura crear(TipoFacturaDTO dto);
    TipoFactura actualizar(Long id, TipoFacturaDTO dto);
    void eliminar(Long id);

}
