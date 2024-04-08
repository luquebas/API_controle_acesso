package com.api_controle_acesso.DTOs.HorarioDTO;

import java.time.LocalDateTime;

import com.api_controle_acesso.models.Curso;
import com.api_controle_acesso.models.enums.DiaSemana;

import jakarta.validation.constraints.NotBlank;

public record HorarioPostDTO(@NotBlank DiaSemana diaSemana, @NotBlank LocalDateTime horario_entrada, @NotBlank LocalDateTime horario_saida, Curso curso) {
    
}
