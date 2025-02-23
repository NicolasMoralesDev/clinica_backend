package com.clinica.spring_security_jwt.servicio;

import com.clinica.spring_security_jwt.dto.UsuarioRequestDTO;
import com.clinica.spring_security_jwt.dto.UsuarioResponseDTO;
import com.clinica.spring_security_jwt.modelo.Usuario;

import java.util.List;

public interface IUserService {

    List<UsuarioResponseDTO> obtenerTodos();
    UsuarioResponseDTO obtenerPorId(Long id);
    UsuarioResponseDTO actualizarPorId(Long id, UsuarioRequestDTO dto);
    Usuario obtenerPorNombre(String nombre);


}
