package com.clinica.spring_security_jwt.dto;

import com.clinica.spring_security_jwt.modelo.Roles;

import java.util.List;

public class UsuarioRequestDTO {

    private String nombre;
    private String password;
    private List<String> roles;


}
