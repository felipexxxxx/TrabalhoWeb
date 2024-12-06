package com.example.Back_end.Web.Entities.User;

import com.example.Back_end.Web.DTOs.NewUserDTO;

public interface UserFactory {
    User createUser(NewUserDTO newUserDTO);
}
