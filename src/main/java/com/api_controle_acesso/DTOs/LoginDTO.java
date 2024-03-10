package com.api_controle_acesso.DTOs;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String matricula, @NotBlank String senha) {

}  