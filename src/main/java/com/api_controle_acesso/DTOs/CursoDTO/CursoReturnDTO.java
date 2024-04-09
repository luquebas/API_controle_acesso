package com.api_controle_acesso.DTOs.CursoDTO;

import java.util.UUID;

import com.api_controle_acesso.models.Curso;

public record CursoReturnDTO(UUID id, String nome, Integer duracao) {
    public CursoReturnDTO(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getDuracao());
    }
} 
