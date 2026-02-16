package com.example.intership.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intership.entities.Offre;

@Repository
public interface OffreRepository extends JpaRepository<Offre,Long> {
    List<Offre> findByTechnologie(String technologie);

}
