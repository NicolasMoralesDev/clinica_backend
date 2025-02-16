package com.clinica.MedPatientService.repository;

import com.clinica.MedPatientService.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicoRepository extends JpaRepository<Medico, Long> {

    @Query("SELECT m FROM Medico m WHERE m.activo = true ")
    @Override
    List<Medico> findAll();
}
