package com.api_controle_acesso.models;
import java.time.LocalTime;

import com.api_controle_acesso.DTOs.HorarioDTO.HorarioPostDTO;
import com.api_controle_acesso.DTOs.HorarioDTO.HorarioPutDTO;
import com.api_controle_acesso.models.enums.DiaSemana;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "horario")
public class Horario {
    
    public Horario(HorarioPostDTO horarioPostDTO) {
        this.diaSemana = horarioPostDTO.diaSemana();
        this.horario_entrada = horarioPostDTO.horario_entrada();
        this.horario_saida = horarioPostDTO.horario_saida();
        this.curso = horarioPostDTO.curso();
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dia_da_semana")
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    @Column(name = "horario_entrada")
    private LocalTime horario_entrada;

    @Column(name = "horario_saida")
    private LocalTime horario_saida;

    @JoinColumn(name = "curso_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Curso curso;

    public void update(@Valid HorarioPutDTO horarioPutDTO) {
        if (horarioPutDTO.diaSemana() != null)
            this.diaSemana = horarioPutDTO.diaSemana();
        
        if (horarioPutDTO.horario_entrada() != null)
            this.horario_entrada = horarioPutDTO.horario_entrada();

        if (horarioPutDTO.horario_saida() != null) {
            this.horario_saida = horarioPutDTO.horario_saida();
        }

        if (horarioPutDTO.curso() != null) {
            this.curso = horarioPutDTO.curso();
        }
    }
 
}
