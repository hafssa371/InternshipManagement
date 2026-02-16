package com.example.intership.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class DashboardDTO {
    private long users;
    private long offers;
    private long candidatures;

}
