package com.example.intership.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "CANDIDATURES")
@Getter  @Setter
@NoArgsConstructor    @AllArgsConstructor
@Builder

public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "candidature_seq")
    @SequenceGenerator(name = "candidature_seq", sequenceName = "CANDIDATURE_SEQ", allocationSize = 1)

    private Long id;
    private LocalDateTime dateCandidature;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    private String cvFileName;
    @ManyToOne
    private User candidat;
    @ManyToOne
    private Offre offre;
}