package com.example.intership.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.intership.repositories.*;
import com.example.intership.dto.DashboardDTO;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserRepository userRepository;
    private final OffreRepository offreRepository;
    private final CandidatureRepository candidatureRepository;

    @GetMapping("/api/dashboard")
    public DashboardDTO dashboard() {
        return new DashboardDTO(
                userRepository.count(),
                offreRepository.count(),
                candidatureRepository.count()
        );
    }


}
