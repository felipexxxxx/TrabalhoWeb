package com.example.Back_end.Web.DTOs;

import java.time.LocalTime;
import java.time.LocalDate;

public record CreatePasseioDTO(
    String nome,
    String lugar,
    String descricao,
    LocalDate data,
    String hora,  // Mudamos para String e faremos a conversão depois
    Double valor
) {
}