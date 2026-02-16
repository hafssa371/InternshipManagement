package com.example.intership.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.intership.entities.Candidature;
import com.example.intership.entities.Statut;
import com.example.intership.service.CandidatureService;
import com.example.intership.service.FileStorageService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/candidatures")
@RequiredArgsConstructor
public class CandidatureController {
    private final CandidatureService candidatureService;
    private final FileStorageService fileStorageService;

    @PostMapping("/postulCandidature")
    public ResponseEntity<?> postuler(@RequestParam Long candidatId, @RequestParam Long offreId, @RequestParam("cv") MultipartFile cv) throws IOException{
        return ResponseEntity.ok(candidatureService.postulCandidature(candidatId,offreId,cv));
    }

    @GetMapping
    public ResponseEntity<List<Candidature>> getAll(){
        return ResponseEntity.ok(candidatureService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidature> updateStatut(@PathVariable Long id, @RequestParam Statut statut) {
        return ResponseEntity.ok(candidatureService.updateStatut(id,statut));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> detete(Long id){
        candidatureService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // TELECHARGER CV
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadCV(
            @PathVariable String fileName) throws IOException {

        Resource resource = fileStorageService.loadFile(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }


    

}
