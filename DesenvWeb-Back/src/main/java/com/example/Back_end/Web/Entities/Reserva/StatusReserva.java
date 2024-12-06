package com.example.Back_end.Web.Entities.Reserva;

public enum StatusReserva {
    PENDENTE("PENDENTE"),
    CONFIRMADO("CONFIRMADO"),
    CANCELADO("CANCELADO");

    private String role;
    StatusReserva(String role) {
        this.role = role;
    }
}
