package com.api_controle_acesso.services;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api_controle_acesso.DTOs.CursoDTO.CursoPostDTO;
import com.api_controle_acesso.DTOs.CursoDTO.CursoReturnDTO;
import com.api_controle_acesso.models.Curso;
import com.api_controle_acesso.repositories.CursoRepository;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    public Curso criarCurso(CursoPostDTO cursoPostDTO) {
        var curso = new Curso(cursoPostDTO);

        return cursoRepository.save(curso);
    }

    public Page<CursoReturnDTO> visualizarCursos(Pageable pageable) {
        var page = cursoRepository.findAll(pageable).map(CursoReturnDTO::new);
        return page;
    }

    public Curso visualizarCurso(UUID id) {
        return cursoRepository.getReferenceById(id);
    }

    public void deleteCurso(UUID id) {
        var curso = cursoRepository.getReferenceById(id);
        try {
            cursoRepository.delete(curso);
        } catch (Exception e) {
            throw new RuntimeException("Não foi Possível excluir o Curso!");
        }
    }
}
