package com.api_controle_acesso.DTOs;
import java.time.LocalDate;
import java.util.UUID;

import com.api_controle_acesso.models.Usuario;

public record UsuarioReturnDTO(UUID id, String nome, LocalDate dataNascimento, String matricula, String curso, String cpf, String email ,String senha, String foto, String nivel) {
    
    public UsuarioReturnDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getDataNascimento(), usuario.getMatricula(), usuario.getCurso(), usuario.getCpf(), usuario.getEmail() ,usuario.getSenha(), usuario.getFoto(), usuario.getNivel());
    }
}