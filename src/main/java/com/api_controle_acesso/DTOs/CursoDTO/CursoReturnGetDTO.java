package com.api_controle_acesso.DTOs.CursoDTO;
import java.util.UUID;
import java.util.List;
import com.api_controle_acesso.DTOs.HorarioDTO.HorarioReturnDTO;
import com.api_controle_acesso.DTOs.UsuarioDTO.UsuarioReturnDTO;
import com.api_controle_acesso.models.Curso;

public record CursoReturnGetDTO(UUID id, String nome, Integer duracao, List<UsuarioReturnDTO> usuarios, List<HorarioReturnDTO> horarios) {
    public CursoReturnGetDTO(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getDuracao(), curso.getUsuarios().stream().map(UsuarioReturnDTO::new).toList(), curso.getHorarios().stream().map(HorarioReturnDTO::new).toList());
    }
}
