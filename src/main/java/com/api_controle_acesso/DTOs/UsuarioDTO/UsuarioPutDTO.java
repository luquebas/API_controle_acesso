package com.api_controle_acesso.DTOs.UsuarioDTO;
import jakarta.validation.constraints.NotNull;

public record UsuarioPutDTO(@NotNull Long id, String email, Long curso_id) {
    
}
