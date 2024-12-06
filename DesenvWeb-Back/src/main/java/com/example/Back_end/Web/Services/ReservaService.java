package com.example.Back_end.Web.Services;

import com.example.Back_end.Web.DTOs.ReservaDTO;
import com.example.Back_end.Web.Entities.Passeio.Passeio;
import com.example.Back_end.Web.Entities.Reserva.Reserva;
import com.example.Back_end.Web.Entities.Reserva.StatusReserva;
import com.example.Back_end.Web.Entities.User.User;
import com.example.Back_end.Web.Repositories.PasseioRepository;
import com.example.Back_end.Web.Repositories.ReservaRepository;
import com.example.Back_end.Web.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasseioRepository passeioRepository;
    @Autowired
    EmailSenderService emailService;

    public Reserva createReserva(ReservaDTO reservaData) {
        try {
                User cliente = userRepository.findById(reservaData.id_cliente())
                        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

                Passeio passeio = passeioRepository.findById(reservaData.id_passeio())
                    .orElseThrow(() -> new RuntimeException("Passeio não encontrado"));

                Reserva reserva = new Reserva(reservaData);
                reserva.setCliente(cliente);
                reserva.setPasseio(passeio);

                LocalDateTime localDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = localDateTime.format(formatter);
                reserva.setData(formattedDateTime);

                emailService.sendEmail(cliente.getEmail(), "RESERVA", "reserva feita com sucesso" +
                        "\n Dia: "+reserva.getData()+
                        "\n"+reserva.getPasseio().toString()+
                        "\n status: "+reserva.getStatus());
                return reservaRepository.save(reserva);

        }
        catch (Exception e){
            throw new RuntimeException("Erro ao criar reserva");
        }
    }

    public Page<Reserva> getReservas(Pageable pageable){
        return reservaRepository.findAll(pageable).map(reserva -> reserva);
    }

    public Reserva confirmarReserva(Integer id){
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        reserva.setStatus(StatusReserva.CONFIRMADO);

        User cliente = reserva.getCliente();

        emailService.sendEmail(cliente.getEmail(), "Reserva de passeio",
                "Pagamento Confirmado!" +
                "\n Dia: "+reserva.getData()+
                "\n"+reserva.getPasseio().toString()+
                "\n status: "+reserva.getStatus());
        return reservaRepository.save(reserva);
    }

    public Reserva cancelarReserva(Integer id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        reserva.setStatus(StatusReserva.CANCELADO);

        User cliente = reserva.getCliente();

        emailService.sendEmail(cliente.getEmail(), "Reserva de passeio para "+reserva.getPasseio().getLugar(),
                "Reserva Cancelada!");

        return reservaRepository.save(reserva);
    }
}
