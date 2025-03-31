package com.clinica.spring_security_jwt.repositorio;

import com.clinica.spring_security_jwt.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findUsuarioByNombre(String nombre);


}
