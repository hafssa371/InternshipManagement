package com.example.intership.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.intership.entities.Candidature;
import com.example.intership.entities.Offre;
import com.example.intership.entities.Statut;
import com.example.intership.entities.User;
import com.example.intership.repositories.CandidatureRepository;
import com.example.intership.repositories.OffreRepository;
import com.example.intership.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidatureService {
    private final CandidatureRepository candidatureRepository;
    private final UserRepository userRepository;
    private final OffreRepository offreRepository;
    private final FileStorageService fileStorageService;

    public Candidature postulCandidature(Long candidatId, Long offreId, MultipartFile cvFile) throws IOException{
        User candidat = userRepository.findById(candidatId).orElseThrow(() -> new RuntimeException("Candidat not found"));
        Offre offre = offreRepository.findById(offreId).orElseThrow(() -> new RuntimeException("Offre not found"));
        String fileName = fileStorageService.storeFile(cvFile);

        Candidature candidature = Candidature.builder()
            .candidat(candidat)
            .offre(offre)
            .dateCandidature(LocalDateTime.now())
            .statut(Statut.EN_ATTENTE)
            .cvFileName(fileName)
            .build();
        return candidatureRepository.save(candidature);
    }

    public List<Candidature> getAll(){
        return candidatureRepository.findAll();
    }
    
    public Candidature updateStatut(Long id, Statut statut){
        Candidature candidature = candidatureRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        candidature.setStatut(statut);
        return candidatureRepository.save(candidature);
    }

    public void delete(Long id){
        candidatureRepository.deleteById(id);
    }

}
