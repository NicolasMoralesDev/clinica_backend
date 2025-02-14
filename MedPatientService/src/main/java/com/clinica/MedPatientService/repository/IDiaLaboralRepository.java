package com.clinica.MedPatientService.repository;

import com.clinica.MedPatientService.entity.DiaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDiaLaboralRepository extends JpaRepository<DiaLaboral, Long> {

    @Query("SELECT d FROM DiaLaboral d WHERE d.borrado = false")
    @Override
    List<DiaLaboral> findAll();
}
