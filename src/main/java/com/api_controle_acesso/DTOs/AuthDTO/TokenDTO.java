package com.api_controle_acesso.DTOs.AuthDTO;
import java.util.UUID;

public record TokenDTO(UUID id, String nome, String email, String foto, String tokenJWT) {

} 
