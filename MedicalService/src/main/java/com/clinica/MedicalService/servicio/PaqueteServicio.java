package com.clinica.MedicalService.servicio;

import com.clinica.MedicalService.DTO.PaqueteConPrecioDTOResponse;
import com.clinica.MedicalService.DTO.PaqueteDTO;
import com.clinica.MedicalService.Excepciones.PaqueteNoEncontradoExcepcion;
import com.clinica.MedicalService.mapper.PaqueteMapper;
import com.clinica.MedicalService.modelo.Paquete;
import com.clinica.MedicalService.modelo.ServicioIndividual;
import com.clinica.MedicalService.repositorio.PaqueteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaqueteServicio implements IPaqueteServicio {

    private final PaqueteRepositorio paqueteRepositorio;
    private final ServicioIndividualServicio servicioIndividualServicio;
    private final PaqueteMapper paqueteMapper;

    @Override
    public List<Paquete> listarTodos() {
        return paqueteRepositorio.findAll();
    }

    @Override
    public Paquete obtenerPorId(Long id) {
        return paqueteRepositorio.findById(id).orElse(null);
    }

    @Override
    public Paquete crear(PaqueteDTO dto) {
        List<ServicioIndividual> servicioIndividualList = servicioIndividualServicio.obtenerTodosPorId(dto.getServicios());

        Paquete paquete = paqueteMapper.toEntity(dto, servicioIndividualList);
        return paqueteRepositorio.save(paquete);
    }

    @Override
    public Paquete actualizar(Long id, PaqueteDTO dto) {
            Paquete paquete = this.obtenerPorId(id);
            if(paquete == null) throw new PaqueteNoEncontradoExcepcion("El paquete no existe");


            if(dto.getNombre() != null && !dto.getNombre().isBlank() &&
                    !dto.getNombre().equals(paquete.getNombre())) paquete.setNombre(dto.getNombre());

            if(dto.getDescripcion() != null && !dto.getDescripcion().isBlank() &&
                    !dto.getDescripcion().equals(paquete.getDescripcion())) paquete.setDescripcion(dto.getDescripcion());

            if(dto.getCodigo() != null && !dto.getCodigo().isBlank() &&
                    !dto.getCodigo().equals(paquete.getCodigo())) paquete.setCodigo(dto.getCodigo());

            //obtengo los id de los servicios del paquete en la bd
            if(dto.getServicios() != null && dto.getServicios().size() > 0){

                List<Long> serviciosActualesId = paquete.getServicios().stream()
                        .map(ServicioIndividual::getIdServicio)
                        .toList();

                //comparo si los servicios cambiaron a traves de 2 hashset
                // Al ser a traves de hashset se comparan los elementos sin importar el orden
                //!new invierte el resultado de la compraracion
                boolean sonDiferentes = !new HashSet<>(serviciosActualesId).equals(new HashSet<>(dto.getServicios()));

                if(sonDiferentes){
                    List<ServicioIndividual> servicioIndividualList = servicioIndividualServicio.obtenerTodosPorId(dto.getServicios());
                    paquete.setServicios(servicioIndividualList);
                }
            }

            return paqueteRepositorio.save(paquete);
    }

    @Override
    public void eliminar(Long id) {
        Paquete paquete = this.obtenerPorId(id);
        if(paquete== null) throw new PaqueteNoEncontradoExcepcion("No existe el paquete");
        paquete.setBorrado(true);
        paqueteRepositorio.save(paquete);
    }

    @Override
    public PaqueteConPrecioDTOResponse obtenerPaqueteConPrecio(Long id) {
        Paquete paquete = this.obtenerPorId(id);

        double precio = 0;

        for (ServicioIndividual item: paquete.getServicios()) {
            System.out.println(item.getPrecio());
            precio += item.getPrecio();
        }

        double precioConDescuento = precio - (precio *  15 / 100);

        return new PaqueteConPrecioDTOResponse(paquete.getNombre(), paquete.getDescripcion(), paquete.getCodigo(),
                paquete.getServicios(), precioConDescuento);
    }
}
