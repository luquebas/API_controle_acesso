package com.api_controle_acesso.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.api_controle_acesso.DTOs.UsuarioPostDTO;
import com.api_controle_acesso.DTOs.UsuarioReturnDTO;
import com.api_controle_acesso.services.UsuarioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping
    @Transactional
    public ResponseEntity<Object> criarUsuario(@RequestBody @Valid UsuarioPostDTO dadosUsuario, UriComponentsBuilder uriComponentsBuilder) {
        
        var usuario = usuarioService.criarUsuario(dadosUsuario);
        var uri = uriComponentsBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new UsuarioReturnDTO(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioReturnDTO>> getUsuarios(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return ResponseEntity.ok(usuarioService.visualizarUsuarios(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuario(@PathVariable UUID id) {
        var usuario = usuarioService.visualizarUsuario(id);
        return ResponseEntity.ok(new UsuarioReturnDTO(usuario));
    }

}
