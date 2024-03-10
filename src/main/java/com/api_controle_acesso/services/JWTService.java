package com.api_controle_acesso.services;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.api_controle_acesso.models.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class JWTService {
    
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                .withIssuer("API Controle Acesso")
                .withSubject(usuario.getMatricula())
                .withExpiresAt(dataExpiracao())
                .sign(algorithm);
        } catch (JWTCreationException e) {
           throw new RuntimeException("Erro ao gerar o JWToken");
        }
    }

    public String validarToken(String JWToken) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
            .withIssuer("API Controle Acesso")
            .build()
            .verify(JWToken)
            .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token Inválido ou Expirado, faça Login Novamente!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.of("-03:00"));
    }
}