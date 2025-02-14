package com.clinica.MedPatientService.repository;

import com.clinica.MedPatientService.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Long> {

    @Query("SELECT e FROM Especialidad e WHERE e.borrado = false")
    @Override
    List<Especialidad> findAll();
}
