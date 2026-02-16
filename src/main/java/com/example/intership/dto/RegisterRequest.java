package com.example.intership.dto;

import com.example.intership.entities.Role;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;

}
