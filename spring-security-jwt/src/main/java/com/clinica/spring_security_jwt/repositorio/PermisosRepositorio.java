package com.clinica.spring_security_jwt.repositorio;

import com.clinica.spring_security_jwt.modelo.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisosRepositorio extends JpaRepository<Permisos, Long> {
}
