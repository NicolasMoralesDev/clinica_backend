package com.clinica.MedicalConsultationService.repository.impl;

import com.clinica.MedicalConsultationService.dto.ConsultaMedicaFiltroDTO;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;
import com.clinica.MedicalConsultationService.repository.IConsultaMedicaFiltroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultaMedicaFiltroRepository implements IConsultaMedicaFiltroRepository {

    private final EntityManager em;

    public ConsultaMedicaFiltroRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ConsultaMedica> findByFilter(ConsultaMedicaFiltroDTO consultaMedicaFiltro) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConsultaMedica> cr = cb.createQuery(ConsultaMedica.class);

        try {
            Root<ConsultaMedica> root = cr.from(ConsultaMedica.class);
            List<Predicate> predicates = new ArrayList<>();

            if (consultaMedicaFiltro.getMedico() != null) {
                predicates.add(cb.equal(root.get("medico"), consultaMedicaFiltro.getMedico()));
            }
            if (consultaMedicaFiltro.getPaciente() != null) {
                predicates.add(cb.equal(root.get("paciente"), consultaMedicaFiltro.getPaciente()));
            }
                predicates.add(cb.equal(root.get("borrado"), consultaMedicaFiltro.isAbierta()));
            cr.select(root).where(predicates.toArray(new Predicate[0]));

            return em.createQuery(cr).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em.createQuery(cr).getResultList();
    }
}
