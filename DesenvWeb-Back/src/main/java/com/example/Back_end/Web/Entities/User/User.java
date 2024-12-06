package com.example.Back_end.Web.Entities.User;

import com.example.Back_end.Web.DTOs.NewUserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="usuario")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    @Column(name = "nome", nullable = false)
    String nome;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "senha", nullable = false)
            @JsonIgnore
    String senha;


    @Column(name = "data_nascimento", nullable = false)
    Date dataNascimento;

    @Column(name = "CPF")
            @JsonIgnore
    String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    Role role;


    public User(NewUserDTO data){
        this.nome = data.nome();
        this.email = data.email();
        this.senha = data.senha();
        this.dataNascimento = data.dataNascimento();
        this.cpf = data.cpf();
        this.role = data.role();
    }
}
