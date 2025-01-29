package com.clinica.finance_service.servicio;

import com.clinica.finance_service.DTO.TipoFacturaDTO;
import com.clinica.finance_service.Excepciones.TipoFacturaNoEncontradoExcepcion;
import com.clinica.finance_service.Mappers.TipoFacturaMapper;
import com.clinica.finance_service.modelo.Factura;
import com.clinica.finance_service.modelo.TipoFactura;
import com.clinica.finance_service.repositorio.TipoFacturaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoFacturaServicio implements ITipoFacturaServicio  {

    private final TipoFacturaRepositorio tipoFacturaRepositorio;
    private final TipoFacturaMapper tipoFacturaMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TipoFactura> listarTodos() {
        return tipoFacturaRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoFactura obtenerPorId(Long id) {
        return tipoFacturaRepositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public TipoFactura crear(TipoFacturaDTO dto) {
        TipoFactura tipoFactura = tipoFacturaMapper.toEntity(dto);
        return tipoFacturaRepositorio.save(tipoFactura);
    }

    @Override
    @Transactional
    public TipoFactura actualizar(Long id, TipoFacturaDTO dto) {
        TipoFactura tipoFactura = this.obtenerPorId(id);
        if( tipoFactura == null) throw new TipoFacturaNoEncontradoExcepcion("El TipoFactura no existe");

        if(dto.getNombre() != null && !dto.getNombre().isBlank() &&
                !dto.getNombre().equals(tipoFactura.getNombre())) tipoFactura.setNombre(dto.getNombre());

        return tipoFactura;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        TipoFactura tipoFactura = this.obtenerPorId(id);
        if(tipoFactura == null) throw new TipoFacturaNoEncontradoExcepcion("El TipoFactura no existe");
        tipoFactura.setBorrado(true);
    }
}
