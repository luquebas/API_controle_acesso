package com.api_controle_acesso.DTOs.CursoDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record CursoPutDTO(@NotBlank UUID id, String nome, Integer duracao) {
    
}
