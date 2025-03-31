package com.clinica.auth_service.controlador;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello-1")
    @PreAuthorize("hasRole('admin_client_role')")
    public String helloAdmin(){
        return "Hello Spring Boot with KeyCloak - ADMIN";
    }


    @PreAuthorize("hasAnyRole('user_client_role', 'admin_client_role')")
    @GetMapping("/hello-2")
    public String helloUser(){
        return "Hello Spring Boot with KeyCloak - USER";
    }
}
