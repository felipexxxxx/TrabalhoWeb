package com.example.Back_end.Web.DTOs;

import com.example.Back_end.Web.Entities.User.Role;

public record LoginResponseDTO (
        int id,
        String name,
        Role role,
        String token
){
}
