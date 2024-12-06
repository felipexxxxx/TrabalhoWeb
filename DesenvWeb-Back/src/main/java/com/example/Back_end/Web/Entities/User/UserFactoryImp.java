package com.example.Back_end.Web.Entities.User;

import com.example.Back_end.Web.DTOs.NewUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserFactoryImp implements UserFactory {

    @Override
    public User createUser(NewUserDTO newUserDTO) {
        return new User(newUserDTO);
    }
}
