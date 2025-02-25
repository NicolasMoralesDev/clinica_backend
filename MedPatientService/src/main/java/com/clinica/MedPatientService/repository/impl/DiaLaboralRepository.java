package com.clinica.MedPatientService.repository.impl;

import com.clinica.MedPatientService.entity.DiaLaboral;
import com.clinica.MedPatientService.repository.IDiaLaboralFiltroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DiaLaboralRepository implements IDiaLaboralFiltroRepository {

    private final EntityManager em;

    public DiaLaboralRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DiaLaboral> buscarTurnosDisponibles(Long idMedico, LocalDate fecha) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DiaLaboral> cr = cb.createQuery(DiaLaboral.class);

        try {
            Root<DiaLaboral> root = cr.from(DiaLaboral.class);
            List<Predicate> predicates = new ArrayList<>();
           root.fetch("medico", JoinType.LEFT);

            predicates.add(cb.equal(root.get("medico").get("id"), idMedico));
            predicates.add(cb.equal(root.get("fechaTurno"), fecha));
            predicates.add(cb.equal(root.get("borrado"), false));
            predicates.add(cb.equal(root.get("disponible"), true));

            cr.select(root).where(predicates.toArray(new Predicate[0]));

            return em.createQuery(cr).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em.createQuery(cr).getResultList();
    }
}
