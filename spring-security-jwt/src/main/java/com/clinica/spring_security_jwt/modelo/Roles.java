package com.clinica.spring_security_jwt.modelo;

import com.clinica.spring_security_jwt.repositorio.RolesRepositorio;
import com.clinica.spring_security_jwt.repositorio.UsuarioRepositorio;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private RoleEnum roleEnum;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rol_permisos", joinColumns = @JoinColumn(name = "rol_id"), inverseJoinColumns = @JoinColumn(name = "permisos_id"))
    private Set<Permisos> permisos = new HashSet<>();

}
