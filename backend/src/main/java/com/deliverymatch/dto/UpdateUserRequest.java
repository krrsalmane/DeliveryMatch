package com.deliverymatch.dto;


import com.deliverymatch.model.Role;
import lombok.Data;

@Data
public class UpdateUserRequest {
    private String nom;
    private String prenom;
    private String email;
    private Role role;
}

