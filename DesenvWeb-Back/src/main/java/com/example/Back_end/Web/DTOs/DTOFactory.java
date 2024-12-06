package com.example.Back_end.Web.DTOs;


import com.example.Back_end.Web.Entities.User.Role;

public interface DTOFactory {
    LoginResponseDTO createLoginResponseDTO(int id,String name, Role role, String token);
}
