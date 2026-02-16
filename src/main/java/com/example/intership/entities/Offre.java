package com.example.intership.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OFFRES")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder

public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offre_seq")
    @SequenceGenerator(name = "offre_seq", sequenceName = "OFFRE_SEQ", allocationSize = 1)

    private Long id;
    private String titre;
    private String description;
    private String technologie;
    private LocalDateTime datePublication;
    @ManyToOne
    @JoinColumn(name = "recruteur_id")
    private User recruteur;
    @OneToMany(mappedBy = "offre")
    private List<Candidature> candidatures;
}
