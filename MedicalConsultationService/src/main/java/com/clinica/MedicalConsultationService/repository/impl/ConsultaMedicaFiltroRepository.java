package com.clinica.MedicalConsultationService.repository.impl;

import com.clinica.MedicalConsultationService.dto.ConsultaMedicaFiltroDTO;
import com.clinica.MedicalConsultationService.dto.ConsultasMedicasParametroDTO;
import com.clinica.MedicalConsultationService.entity.ConsultaMedica;
import com.clinica.MedicalConsultationService.repository.IConsultaMedicaFiltroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
            if (consultaMedicaFiltro.getFecha() != null) {
                predicates.add(cb.equal(root.get("fechaTurno"), consultaMedicaFiltro.getFecha()));
            }
            predicates.add(cb.equal(root.get("borrado"), consultaMedicaFiltro.isAbierta()));

            cr.select(root).where(predicates.toArray(new Predicate[0]));

            return em.createQuery(cr).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em.createQuery(cr).getResultList();
    }

    @Override
    public ConsultaMedica findByParameter(ConsultasMedicasParametroDTO consultasMedicasParametroDTO) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConsultaMedica> cr = cb.createQuery(ConsultaMedica.class);

        try {
            Root<ConsultaMedica> root = cr.from(ConsultaMedica.class);
            List<Predicate> predicates = new ArrayList<>();

            if (consultasMedicasParametroDTO.getId() != null) {
                predicates.add(cb.equal(root.get("medico"), consultasMedicasParametroDTO.getId()));
            }
            if (consultasMedicasParametroDTO.getFecha()!= null) {
                predicates.add(cb.equal(root.get("fechaTurno"), LocalDate.parse(consultasMedicasParametroDTO.getFecha())));
            }
            predicates.add(cb.equal(root.get("borrado"), false));

            cr.select(root).where(predicates.toArray(new Predicate[0]));

            return em.createQuery(cr).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em.createQuery(cr).getSingleResult();
    }
}
