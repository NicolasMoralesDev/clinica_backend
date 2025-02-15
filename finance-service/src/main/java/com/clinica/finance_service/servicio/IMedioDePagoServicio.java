package com.clinica.finance_service.servicio;


import com.clinica.finance_service.dto.MedioDePagoDTO;
import com.clinica.finance_service.modelo.MedioDePago;

import java.util.List;

public interface IMedioDePagoServicio {

    List<MedioDePago> listarTodos();
    MedioDePago obtenerPorId(Long id);
    MedioDePago crear(MedioDePagoDTO dto);
    MedioDePago actualizar(Long id, MedioDePagoDTO dto);
    void eliminar(Long id);
}
