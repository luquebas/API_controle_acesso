package com.api_controle_acesso.DTOs.HorarioDTO;
import java.time.LocalTime;
import java.util.UUID;
import com.api_controle_acesso.models.Curso;
import com.api_controle_acesso.models.enums.DiaSemana;
import jakarta.validation.constraints.NotNull;

public record HorarioPutDTO(@NotNull UUID id, DiaSemana diaSemana, LocalTime horario_entrada, LocalTime horario_saida, Curso curso) {
    
}
