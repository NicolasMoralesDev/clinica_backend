package com.clinica.spring_security_jwt.dto;

import java.util.List;

public record AuthCreateRoleRequest(List<String> roleListName) {
}
