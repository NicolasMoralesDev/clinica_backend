package com.clinica.spring_security_jwt.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String username,
                               @NotBlank String password ) {
}
