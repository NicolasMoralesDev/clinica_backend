package com.clinica.spring_security_jwt.servicio;

import com.clinica.spring_security_jwt.dto.UsuarioRequestDTO;
import com.clinica.spring_security_jwt.dto.UsuarioResponseDTO;
import com.clinica.spring_security_jwt.modelo.Roles;
import com.clinica.spring_security_jwt.modelo.Usuario;
import com.clinica.spring_security_jwt.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UsuarioRepositorio usuarioRepositorio;


    @Override
    public List<UsuarioResponseDTO> obtenerTodos() {
        try{
            List<Usuario> usuarioList = usuarioRepositorio.findAll();
            List<UsuarioResponseDTO> usuarioResponseDTOList = new ArrayList<>();

            for(Usuario user : usuarioList){
                UsuarioResponseDTO dto = UsuarioResponseDTO.builder()
                        .nombre(user.getNombre())
                        .roles(user.getRoles())
                        .build();

                usuarioResponseDTOList.add(dto);
            }

            return usuarioResponseDTOList;
        }catch (Exception e ){
            throw new RuntimeException("Error al obtener todos los usuarios");
        }
    }

    @Override
    public UsuarioResponseDTO obtenerPorId(Long id) {
        try{
            Usuario user = usuarioRepositorio.findById(id).orElse(null);
            if(user != null){
                return UsuarioResponseDTO.builder()
                        .nombre(user.getNombre())
                        .roles(user.getRoles())
                        .build();
            }else{
                throw new UsernameNotFoundException("El usuario no existe");
            }
        }catch (Exception e){
            throw new RuntimeException("Error al obtener el usuario por el id: " + id);
        }
    }

    @Override
    public UsuarioResponseDTO actualizarPorId(Long id, UsuarioRequestDTO dto) {
        return null;
    }

    @Override
    public Usuario obtenerPorNombre(String nombre) {
        try{
            return usuarioRepositorio.findUsuarioByNombre(nombre).orElse(null);
        }catch (Exception e){
            throw new RuntimeException("Error al buscar por nombre");
        }
    }
}
