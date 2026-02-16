package com.example.intership.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intership.entities.Offre;
import com.example.intership.service.OffreService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OffreController {
    private OffreService offreService;

    @PostMapping("/{recruteurId}")
    public ResponseEntity<Offre> create(@RequestBody Offre offre, @PathVariable Long recruteurId) {
        return ResponseEntity.ok(offreService.creatOffre(offre, recruteurId));
    }

    @GetMapping
    public ResponseEntity<List<Offre>> getAll() {
        return ResponseEntity.ok(offreService.getAllOffres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offre> getById(@PathVariable Long id) {
        return ResponseEntity.ok(offreService.getOffreById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offre> update(@PathVariable Long id, @RequestBody Offre offre) {
        return ResponseEntity.ok(offreService.updateOffre(id,offre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffre(Long id){
        offreService.deleteOffre(id);
        return ResponseEntity.noContent().build();
    }
    
    
    

}
