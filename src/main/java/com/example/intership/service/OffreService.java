package com.example.intership.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.intership.entities.Offre;
import com.example.intership.entities.User;
import com.example.intership.repositories.OffreRepository;
import com.example.intership.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OffreService {
    private final OffreRepository offreRepository;
    private final UserRepository userRepository;

    public Offre creatOffre(Offre offre, Long recruteurId){
        User recruteur = userRepository.findById(recruteurId).orElseThrow(() -> new RuntimeException("Recruture not found"));
        offre.setRecruteur(recruteur);
        offre.setDatePublication(LocalDateTime.now());
        return offreRepository.save(offre);
    }

    public List<Offre> getAllOffres(){
        return offreRepository.findAll();
    }

    public Offre getOffreById(long id){
        return offreRepository.findById(id).orElseThrow(() -> new RuntimeException("Offre not found"));

    }

    public Offre updateOffre(Long id, Offre updatedOffre){
        Offre offre = getOffreById(id);
        offre.setTitre(updatedOffre.getTitre());
        offre.setDescription(updatedOffre.getDescription());
        offre.setTechnologie(updatedOffre.getTechnologie());
        return offreRepository.save(offre);
    }

    public void deleteOffre(Long id){
        offreRepository.deleteById(id);
    }

}
