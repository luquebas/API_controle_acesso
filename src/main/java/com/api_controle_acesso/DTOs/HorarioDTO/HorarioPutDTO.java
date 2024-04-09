package com.api_controle_acesso.DTOs.HorarioDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.api_controle_acesso.models.Curso;
import com.api_controle_acesso.models.enums.DiaSemana;

import jakarta.validation.constraints.NotBlank;

public record HorarioPutDTO(@NotBlank UUID id, DiaSemana diaSemana, LocalDateTime horario_entrada, LocalDateTime horario_saida, Curso curso) {
    
}
