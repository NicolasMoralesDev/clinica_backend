package com.clinica.finance_service.servicio;

import com.clinica.finance_service.dto.MedioDePagoDTO;
import com.clinica.finance_service.Excepciones.MedioDePagoNoEncontradoExcepcion;
import com.clinica.finance_service.Mappers.MedioDePagoMapper;
import com.clinica.finance_service.modelo.MedioDePago;
import com.clinica.finance_service.repositorio.MedioDePagoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedioDePagoServicio implements IMedioDePagoServicio {

    private final MedioDePagoRepositorio medioDePagoRepositorio;
    private final MedioDePagoMapper medioDePagoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MedioDePago> listarTodos() {
        return medioDePagoRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MedioDePago obtenerPorId(Long id) {
        return medioDePagoRepositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public MedioDePago crear(MedioDePagoDTO dto) {
        MedioDePago medioDePago = medioDePagoMapper.toEntity(dto);
        return medioDePagoRepositorio.save(medioDePago);
    }

    @Override
    @Transactional
    public MedioDePago actualizar(Long id, MedioDePagoDTO dto) {
        MedioDePago medioDePago = this.obtenerPorId(id);
        if(medioDePago == null) throw new MedioDePagoNoEncontradoExcepcion("El medio de pago no existe");

        if(dto.getNombre() != null && !dto.getNombre().isBlank() &&
                !dto.getNombre().equals(medioDePago.getNombre())) medioDePago.setNombre(dto.getNombre());

        if(dto.getIncremento() != null && dto.getIncremento() != medioDePago.getIncremento()) medioDePago.setIncremento(dto.getIncremento());

        return medioDePago;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        MedioDePago medioDePago = this.obtenerPorId(id);
        if(medioDePago == null) throw new MedioDePagoNoEncontradoExcepcion("El medio de pago no existe");
        medioDePago.setBorrado(true);
    }
}
