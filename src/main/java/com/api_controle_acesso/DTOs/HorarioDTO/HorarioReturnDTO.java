package com.api_controle_acesso.DTOs.HorarioDTO;
import java.time.LocalTime;
import java.util.UUID;
import com.api_controle_acesso.DTOs.CursoDTO.CursoReturnDTO;
import com.api_controle_acesso.models.Horario;
import com.api_controle_acesso.models.enums.DiaSemana;

public record HorarioReturnDTO(UUID id, DiaSemana diaSemana, LocalTime horario_entrada, LocalTime horario_saida, CursoReturnDTO curso) {
    
    public HorarioReturnDTO(Horario horario) {
        this(horario.getId(), horario.getDiaSemana(), horario.getHorario_entrada(), horario.getHorario_saida(), new CursoReturnDTO(horario.getCurso()));
    }
}
