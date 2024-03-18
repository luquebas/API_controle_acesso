package com.api_controle_acesso.DTOs.UsuarioDTO;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;

public record UsuarioPutDTO(@NotBlank UUID id, String email, String foto) {
    
}
