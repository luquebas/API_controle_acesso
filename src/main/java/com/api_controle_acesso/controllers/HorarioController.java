package com.api_controle_acesso.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api_controle_acesso.DTOs.HorarioDTO.HorarioPostDTO;
import com.api_controle_acesso.DTOs.HorarioDTO.HorarioPutDTO;
import com.api_controle_acesso.DTOs.HorarioDTO.HorarioReturnDTO;
import com.api_controle_acesso.services.HorarioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/horario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @PostMapping
    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Object> criarHorario(@RequestBody @Valid HorarioPostDTO horarioPostDTO, UriComponentsBuilder uriComponentsBuilder) {
        var horario = horarioService.criarHorario(horarioPostDTO);
        var uri = uriComponentsBuilder.path("horario/{id}").buildAndExpand(horario.getId()).toUri();

        return ResponseEntity.created(uri).body(new HorarioReturnDTO(horario));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Page<HorarioReturnDTO>> visualizarHorarios(@PageableDefault(size = 10, sort = {"curso_id"}) Pageable pageable) {

        return ResponseEntity.ok().body(horarioService.visualizarHorarios(pageable));
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Object> visualizarHorario(@PathVariable Long id) {
        
        var horario = horarioService.visualizarHorario(id);
        return ResponseEntity.ok().body(new HorarioReturnDTO(horario));
    }

    @PutMapping
    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Object> atualizarHorario(@RequestBody @Valid HorarioPutDTO horarioPutDTO) {
        var horario = horarioService.visualizarHorario(horarioPutDTO.id());
        horario.update(horarioPutDTO);

        return ResponseEntity.ok().body(new HorarioReturnDTO(horario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Object> deleteHorario(@PathVariable Long id) {
        horarioService.deleteHorario(id);

        return ResponseEntity.noContent().build();
    }
}
