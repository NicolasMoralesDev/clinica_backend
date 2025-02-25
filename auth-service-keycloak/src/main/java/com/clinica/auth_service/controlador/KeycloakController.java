package com.clinica.auth_service.controlador;

import com.clinica.auth_service.dto.UserDTO;
import com.clinica.auth_service.servicio.IKeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/keycloak/user")
@PreAuthorize("hasRole('admin_client_role')")
public class KeycloakController {

    @Autowired
    private IKeycloakService keycloakService;

    @GetMapping
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(keycloakService.findAllUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> findById(@PathVariable String username){
        return ResponseEntity.ok(keycloakService.searchUserByUsername(username));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        String response = keycloakService.createUser(userDTO);
        return ResponseEntity.created(URI.create("/keycloak/user/" + userDTO.getUsername())).body(response);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId,  @RequestBody UserDTO userDTO){
       keycloakService.updateUser(userId, userDTO);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        keycloakService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
