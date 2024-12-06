package com.example.Back_end.Web.Controller;
import com.example.Back_end.Web.DTOs.LoginDTO;
import com.example.Back_end.Web.DTOs.LoginResponseDTO;
import com.example.Back_end.Web.DTOs.NewUserDTO;
import com.example.Back_end.Web.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody NewUserDTO data) {
        userService.createUser(data);
        return ResponseEntity.ok("eu aceito esse usuario, obrigado. COloquei ele no banco");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginDTO data) {
        LoginResponseDTO userData = userService.loginUser(data.email(), data.senha());
        return ResponseEntity.ok(userData);
    }

}
