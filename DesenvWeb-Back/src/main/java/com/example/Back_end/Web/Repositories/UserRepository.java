package com.example.Back_end.Web.Repositories;

import com.example.Back_end.Web.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByCpf(String cpf);

}
