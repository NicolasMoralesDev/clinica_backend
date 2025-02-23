package com.clinica.spring_security_jwt.dto;

import com.clinica.spring_security_jwt.modelo.Roles;
import lombok.*;

import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioResponseDTO {

    private Long id;
    private String nombre;
    private Set<Roles> roles;

}
