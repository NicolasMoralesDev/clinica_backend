package com.clinica.MedPatientService.repository;

import com.clinica.MedPatientService.entity.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEnfermedadRepository extends JpaRepository<Enfermedad, Long> {

    @Query("SELECT e FROM Enfermedad e WHERE e.borrado = false")
    @Override
    List<Enfermedad> findAll();
}
