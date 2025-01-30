package com.clinica.finance_service.servicio;


import com.clinica.finance_service.DTO.CobroDTO;
import com.clinica.finance_service.modelo.Cobro;

import java.util.List;

public interface ICobroServicio {

    List<Cobro> listarTodos();
    Cobro obtenerPorId(Long id);
    Cobro crear(CobroDTO dto);
    Cobro actualizar(Long id , CobroDTO dto);
    void eliminar(Long id);

    List<Cobro> bloquearCobros(Long idFactura);


}
