package com.api_controle_acesso.DTOs.AuthDTO;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String matricula, @NotBlank String senha) {

}  