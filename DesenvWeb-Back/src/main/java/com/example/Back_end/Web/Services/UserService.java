package com.example.Back_end.Web.Services;


import com.example.Back_end.Web.DTOs.DTOFactory;
import com.example.Back_end.Web.DTOs.LoginResponseDTO;
import com.example.Back_end.Web.DTOs.NewUserDTO;
import com.example.Back_end.Web.Entities.User.User;
import com.example.Back_end.Web.Entities.User.UserFactory;
import com.example.Back_end.Web.Exceptions.DuplicateException;
import com.example.Back_end.Web.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserFactory userFactory;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    DTOFactory dtoFactory;
    @Autowired
    TokenService tokenService;

    public User createUser(NewUserDTO newUserDTO) throws DuplicateException {
        if(userRepository.findByEmail(newUserDTO.email()) != null) {
            throw new DuplicateException("email já cadastrado!");
        }
        if(userRepository.findByCpf(newUserDTO.cpf()) != null) {
            throw new DuplicateException("cpf já cadastrado!");
        }
        User newUser = userFactory.createUser(newUserDTO);
        newUser.setSenha(passwordEncoder.encode(newUser.getSenha()));
        return userRepository.save(newUser);
    }

    public LoginResponseDTO loginUser(String email, String password) {
        User userToFind = userRepository.findByEmail(email);
        if(userToFind != null) {
            if(passwordEncoder.matches(password, userToFind.getSenha())) {
                // Gera o token após a validação
                String token = tokenService.generateToken(userToFind);
                return dtoFactory.createLoginResponseDTO(userToFind.getId(),userToFind.getNome(),userToFind.getRole(),token);
            } else {
                throw new BadCredentialsException("senha inválida!");
            }
        } else {
            throw new BadCredentialsException("email inexistente!");
        }
    }
}
