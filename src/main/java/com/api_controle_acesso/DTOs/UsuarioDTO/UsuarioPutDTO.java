package com.api_controle_acesso.DTOs.UsuarioDTO;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;

public record UsuarioPutDTO(@NotNull UUID id, String email, String foto, UUID curso_id) {
    
}
