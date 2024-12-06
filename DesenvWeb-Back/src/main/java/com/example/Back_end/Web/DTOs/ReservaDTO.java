package com.example.Back_end.Web.DTOs;

import com.example.Back_end.Web.Entities.Reserva.StatusReserva;
import com.example.Back_end.Web.Entities.User.User;

import java.util.Date;

public record ReservaDTO(
        Integer id_cliente,
        Integer id_passeio,
        double valor_total
) {}
