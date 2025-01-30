package com.clinica.MedicalService.servicio;

import com.clinica.MedicalService.DTO.ServicioIndividualDTO;
import com.clinica.MedicalService.Excepciones.CategoriaNoEncontradaExcepcion;
import com.clinica.MedicalService.Excepciones.ServicioIndividualNoEncontradaExcepcion;
import com.clinica.MedicalService.mapper.ServicioIndividualMapper;
import com.clinica.MedicalService.modelo.Categoria;
import com.clinica.MedicalService.modelo.ServicioIndividual;
import com.clinica.MedicalService.repositorio.ServicioIndividualRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioIndividualServicio implements IServicioIndividualServicio {

    private final ServicioIndividualRepositorio servicioIndividualRepositorio;
    private final CategoriaServicio categoriaServicio;
    private final ServicioIndividualMapper servicioIndividualMapper;


    @Override
    public List<ServicioIndividual> listarTodos() {
        return servicioIndividualRepositorio.findAll();
    }

    @Override
    public ServicioIndividual obtenerPorId(Long id) {
        return servicioIndividualRepositorio.findById(id).orElse(null);
    }

    /**
     * <p>Este metodo convierte el objeto {@link ServicioIndividualDTO} recibido como parametro
     * en una entidad {@link ServicioIndividual} utilizando el mapeador {@link ServicioIndividualMapper}
     * y luego la persiste en la base de datos<p/>
     *
     * @param dto {@link ServicioIndividualDTO}
     * @return {@link ServicioIndividual}
     */
    @Override
    public ServicioIndividual crear(ServicioIndividualDTO dto) {
        Categoria categoria = categoriaServicio.obtenerPorId(dto.getCategoria());
        if(categoria == null) throw new CategoriaNoEncontradaExcepcion("La categoria no existe");

        ServicioIndividual servicioIndividual = servicioIndividualMapper.toEntity(dto, categoria);
        return servicioIndividualRepositorio.save(servicioIndividual);
    }


    /**
     * <p>Este metodo actualiza el objeto {@link ServicioIndividual} comparando los datos recibidos por el cliente
     *  del objeto {@link ServicioIndividualDTO} de modo que unicamente actualiza los valores presentes en la solicitud
     * y luego la persiste en la base de datos<p/>
     *
     * @param id El identidicador unico del ServicioIndividual
     * @param dto {@link ServicioIndividualDTO}
     * @return {@link ServicioIndividual}
     */
    @Override
    public ServicioIndividual actualizar(Long id, ServicioIndividualDTO dto) {

        ServicioIndividual servicioIndividual = this.obtenerPorId(id);
        if(servicioIndividual==null) throw new ServicioIndividualNoEncontradaExcepcion("El servicio no existe");

        if(dto.getNombre() != null && !dto.getNombre().isBlank() &&
                !dto.getNombre().equals(servicioIndividual.getNombre())) servicioIndividual.setNombre(dto.getNombre());

        if(dto.getDescripcion() != null && !dto.getDescripcion().isBlank()
                && !dto.getDescripcion().equals(servicioIndividual.getDescripcion())) servicioIndividual.setDescripcion(dto.getDescripcion());

        if(dto.getCodigo() != null && !dto.getCodigo().isBlank() &&
                !dto.getCodigo().equals(servicioIndividual.getCodigo())) servicioIndividual.setCodigo(dto.getCodigo());


        if(dto.getPrecio() != null && dto.getPrecio() != servicioIndividual.getPrecio()) servicioIndividual.setPrecio(dto.getPrecio());

        if(dto.getCategoria() != null){
            Categoria categoria = categoriaServicio.obtenerPorId(dto.getCategoria());
            if(categoria==null) throw new CategoriaNoEncontradaExcepcion("La categoria no existe");
            if(dto.getCategoria() != servicioIndividual.getCategoria().getIdCategoria()) servicioIndividual.setCategoria(categoria);
        }
        return servicioIndividualRepositorio.save(servicioIndividual);
    }

    @Override
    public void eliminar(Long id) {
        ServicioIndividual servicioIndividual = this.obtenerPorId(id);
        if(servicioIndividual==null) throw new ServicioIndividualNoEncontradaExcepcion("El servicio no existe");
        servicioIndividual.setBorrado(true);
        servicioIndividualRepositorio.save(servicioIndividual);
    }

    @Override
    public List<ServicioIndividual> obtenerPorCategoria(Long categoriaId) {
        Categoria categoria = categoriaServicio.obtenerPorId(categoriaId);
        if(categoria==null) throw new CategoriaNoEncontradaExcepcion("La categoria no existe");

        return servicioIndividualRepositorio.findByCategoria(categoria);
    }

    @Override
    public List<ServicioIndividual> obtenerTodosPorId(List<Long> listaServiciosId) {
        return servicioIndividualRepositorio.findAllById(listaServiciosId);
    }


}
