package com.example.intership.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.intership.entities.Statut;
import com.example.intership.repositories.CandidatureRepository;
import com.example.intership.repositories.OffreRepository;
import com.example.intership.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final UserRepository userRepository;
    private final OffreRepository offreRepository;
    private final CandidatureRepository candidatureRepository;

    public Map<String, Object> getStats() {

        Map<String, Object> stats = new HashMap<>();

        stats.put("users", userRepository.count());
        stats.put("offres", offreRepository.count());
        stats.put("candidatures", candidatureRepository.count());
        stats.put("enAttente",
                candidatureRepository.countByStatut(Statut.EN_ATTENTE));

        return stats;
    }

}
