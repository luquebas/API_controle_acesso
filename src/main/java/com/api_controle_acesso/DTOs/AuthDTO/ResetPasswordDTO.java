package com.api_controle_acesso.DTOs.AuthDTO;


public record ResetPasswordDTO(String email,  String token, String newPassword) {
    
}
