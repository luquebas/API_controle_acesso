package com.api_controle_acesso.DTOs.HorarioDTO;
import java.time.LocalTime;

import com.api_controle_acesso.models.Curso;
import com.api_controle_acesso.models.enums.DiaSemana;
import jakarta.validation.constraints.NotNull;

public record HorarioPostDTO(@NotNull DiaSemana diaSemana, @NotNull LocalTime horario_entrada, @NotNull LocalTime horario_saida, @NotNull Curso curso) {
    
}
