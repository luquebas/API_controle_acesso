package com.api_controle_acesso.services;

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
}
