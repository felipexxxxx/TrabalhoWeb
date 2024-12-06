package com.example.Back_end.Web.DTOs;

import com.example.Back_end.Web.Entities.User.Role;
import org.springframework.stereotype.Component;

@Component
public class LoginResponseFactory implements DTOFactory{
    @Override
    public LoginResponseDTO createLoginResponseDTO(int id,String name, Role role, String token){
        return new LoginResponseDTO(id,name,role,token);
    }
}
