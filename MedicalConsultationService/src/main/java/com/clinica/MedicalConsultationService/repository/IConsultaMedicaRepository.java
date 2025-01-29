package com.clinica.MedicalConsultationService.repository;

import com.clinica.MedicalConsultationService.entity.ConsultaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IConsultaMedicaRepository extends JpaRepository<ConsultaMedica, Long> {

    @Query("SELECT c FROM ConsultaMedica c WHERE c.borrado = false")
    @Override
    List<ConsultaMedica> findAll();
}
