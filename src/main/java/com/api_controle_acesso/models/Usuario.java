package com.api_controle_acesso.models;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.api_controle_acesso.DTOs.UsuarioDTO.UsuarioPostDTO;
import com.api_controle_acesso.DTOs.UsuarioDTO.UsuarioPutDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails {
    
    public Usuario(UsuarioPostDTO dadosUsuario) {
        this.nome = dadosUsuario.nome();
        this.dataNascimento = dadosUsuario.dataNascimento();
        this.matricula = dadosUsuario.matricula();
        this.curso = dadosUsuario.curso();
        this.cpf = dadosUsuario.cpf();
        this.email = dadosUsuario.email();
        this.senha = dadosUsuario.senha();
        this.foto = dadosUsuario.foto();
        this.nivel = dadosUsuario.nivel();
    }

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "curso")
    private String curso;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "foto")
    private String foto;

    @Column(name = "nivel")
    private String nivel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return matricula;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void update(@Valid UsuarioPutDTO usuarioPutDTO) {
        if (usuarioPutDTO.email() != null)
            this.email = usuarioPutDTO.email();
        
        if (usuarioPutDTO.foto() != null)
            this.foto = usuarioPutDTO.foto();

    }
}
