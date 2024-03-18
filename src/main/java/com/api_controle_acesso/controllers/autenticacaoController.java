package com.api_controle_acesso.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_controle_acesso.DTOs.AuthDTO.LoginDTO;
import com.api_controle_acesso.DTOs.AuthDTO.TokenDTO;
import com.api_controle_acesso.models.Usuario;
import com.api_controle_acesso.services.JWTService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class autenticacaoController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDTO loginDto) {
        
        var authToken = new UsernamePasswordAuthenticationToken(loginDto.matricula(), loginDto.senha());
        var authentication = authenticationManager.authenticate(authToken);
        var jwtToken = jwtService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(jwtToken));
    }
}
