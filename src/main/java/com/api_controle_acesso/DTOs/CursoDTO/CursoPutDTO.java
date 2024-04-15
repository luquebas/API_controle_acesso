package com.api_controle_acesso.DTOs.CursoDTO;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;

public record CursoPutDTO(@NotNull UUID id, String nome, Integer duracao) {
    
}
