package com.api_controle_acesso.models;
import java.time.LocalDate;
import java.util.UUID;
import com.api_controle_acesso.DTOs.UsuarioPostDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class Usuario {
    
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
    @JsonFormat(pattern = "dd/MM/yyyy")
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
}
