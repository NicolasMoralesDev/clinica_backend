package com.clinica.spring_security_jwt.repositorio;

import com.clinica.spring_security_jwt.modelo.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepositorio extends JpaRepository<Roles, Long> {

    List<Roles> findRoleByRoleEnumIn(List<String> roleNames);

}
