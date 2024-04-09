package com.api_controle_acesso.DTOs.CursoDTO;

import jakarta.validation.constraints.NotBlank;

public record CursoPostDTO(@NotBlank String nome, @NotBlank Integer duracao) {
} 
