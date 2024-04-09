package com.api_controle_acesso.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.api_controle_acesso.DTOs.HorarioDTO.HorarioPostDTO;
import com.api_controle_acesso.DTOs.HorarioDTO.HorarioReturnDTO;
import com.api_controle_acesso.models.Horario;
import com.api_controle_acesso.repositories.HorarioRepository;

@Service
public class HorarioService {
    
    @Autowired
    private HorarioRepository horarioRepository;

    public Horario criarHorario(HorarioPostDTO horarioPostDTO) {

        var horario = new Horario(horarioPostDTO);

        return horarioRepository.save(horario);
    }

    public Page<HorarioReturnDTO> visualizarHorarios(Pageable pageable) {
        var page = horarioRepository.findAll(pageable).map(HorarioReturnDTO::new);
        return page;
    }

    public Horario visualizarHorario(UUID id) {
        return horarioRepository.getReferenceById(id);
    }

    public void deleteHorario(UUID id) {
        var horario = horarioRepository.getReferenceById(id);
        try {
            horarioRepository.delete(horario);
        } catch (Exception e) {
            throw new RuntimeException("Não foi Possível deletar o Horário");
        }
    }
}
