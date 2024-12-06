package com.example.Back_end.Web.DTOs;

import com.example.Back_end.Web.Entities.User.Role;

public record UserTokenDTO (
        String name,
        String email,
        Role role
){

}
