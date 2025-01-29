package com.clinica.MedicalService.servicio;

import com.clinica.MedicalService.DTO.CategoriaDTO;
import com.clinica.MedicalService.Excepciones.CategoriaNoEncontradaExcepcion;
import com.clinica.MedicalService.mapper.CategoriaMapper;
import com.clinica.MedicalService.modelo.Categoria;
import com.clinica.MedicalService.repositorio.CategoriaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServicio implements ICategoriaServicio{

    private final CategoriaRepositorio categoriaRepositorio;
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<Categoria> listarTodos() {
        return categoriaRepositorio.findAll();
    }

    @Override
    public Categoria obtenerPorId(Long id) {
        return categoriaRepositorio.findById(id).orElse(null);
    }

    /**
     * <p>Este metodo convierte el objeto {@link CategoriaDTO} recibido como parametro
     * en una entidad {@link Categoria} utilizando el mapeador {@link CategoriaMapper}
     * y luego la persiste en la base de datos<p/>
     *
     * @param dto {@link CategoriaDTO}
     * @return {@link Categoria}
     */
    @Override
    public Categoria crear(CategoriaDTO dto) {
        Categoria categoria = categoriaMapper.toEntity(dto);
        return categoriaRepositorio.save(categoria);
    }


    /**
     * <p>Este metodo busca una categoria existente por su id.
     * Si la categoria no existe, se lanza una excepcion de tipo {@link CategoriaNoEncontradaExcepcion},
     * luego actualiza los campos proporcionados en el objeto {@link CategoriaDTO}
     * que haya enviado el cliente y luego persiste el objeto en la base de datos.<p/>
     * @param id El identificador unico de la categoria a actualizar
     * @param dto {@link CategoriaDTO}
     * @return {@link Categoria}
     */
    @Override
    public Categoria actualizar(Long id, CategoriaDTO dto) {
        Categoria categoria = this.obtenerPorId(id);
        if(categoria == null) throw new CategoriaNoEncontradaExcepcion("La categoria no existe");

        if(dto.getNombre() != null && !dto.getNombre().isBlank() &&
                !dto.getNombre().equals(categoria.getNombre())) categoria.setNombre(dto.getNombre());

        if(dto.getCodigoCategoria() != null && !dto.getCodigoCategoria().isBlank() &&
                !dto.getCodigoCategoria().equals(categoria.getCodigoCategoria())) categoria.setCodigoCategoria(dto.getCodigoCategoria());

        return categoriaRepositorio.save(categoria);
    }

    @Override
    public void eliminar(Long id) {
        Categoria categoria = this.obtenerPorId(id);
        //Pendiente agregar validacion de que si la categoria esta asociada a distintos serviciosMedicos
        if(categoria == null) throw new CategoriaNoEncontradaExcepcion("La categoria no existe");
        categoria.setBorrado(true);
        categoriaRepositorio.save(categoria);
    }
}
