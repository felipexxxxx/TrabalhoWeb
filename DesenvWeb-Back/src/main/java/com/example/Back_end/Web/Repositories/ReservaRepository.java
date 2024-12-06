package com.example.Back_end.Web.Repositories;

import com.example.Back_end.Web.Entities.Reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("SELECT r FROM Reserva r WHERE r.cliente.id = ?1")
    List<Reserva> findByIdCliente(int id);
}
