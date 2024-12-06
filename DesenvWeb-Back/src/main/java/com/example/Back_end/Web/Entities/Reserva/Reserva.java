package com.example.Back_end.Web.Entities.Reserva;

import com.example.Back_end.Web.DTOs.ReservaDTO;
import com.example.Back_end.Web.Entities.Passeio.Passeio;
import com.example.Back_end.Web.Entities.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer ID_reserva;

    @ManyToOne
    @JoinColumn(name = "ID_Cliente")
    User cliente;

    @ManyToOne
    @JoinColumn(name = "ID_passeio")
    Passeio passeio;

    @Column(name = "valor_total")
    Double valorTotal;

    String data;
    @Enumerated(EnumType.STRING)
            @Column(name = "status_reserva")
    StatusReserva status;

    public Reserva(ReservaDTO data) {
        this.valorTotal = data.valor_total();
        this.status = StatusReserva.PENDENTE;
    }
}
