package com.api_controle_acesso.DTOs.HorarioDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.api_controle_acesso.models.Curso;
import com.api_controle_acesso.models.Horario;
import com.api_controle_acesso.models.enums.DiaSemana;

public record HorarioReturnDTO(UUID id, DiaSemana diaSemana, LocalDateTime horario_entrada, LocalDateTime horario_saida, Curso curso) {
    
    public HorarioReturnDTO(Horario horario) {
        this(horario.getId(), horario.getDiaSemana(), horario.getHorario_entrada(), horario.getHorario_saida(), horario.getCurso());
    }
}
