package com.example.intership.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intership.entities.Candidature;
import com.example.intership.entities.Statut;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature,Long> {
    List<Candidature> findByOffreId(Long id);
    List<Candidature> findByCandidatId(Long id);
    Long countByStatut(Statut statut);

}
