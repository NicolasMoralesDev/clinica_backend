package com.clinica.MedicalService.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    @Column(unique = true, nullable = false)
    private String nombre;
    @Column(unique = true, nullable = false )
    private String codigoCategoria;
    @Column(nullable = false)
    private Boolean borrado;


}
