package com.example.Back_end.Web.DTOs;

import com.example.Back_end.Web.Entities.User.Role;
import java.sql.Date;



public record NewUserDTO(
        String nome,
        String email,
        String senha,
        Date dataNascimento,
        String cpf,
        Role role
) {
}
