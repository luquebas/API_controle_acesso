package com.api_controle_acesso.services;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.api_controle_acesso.DTOs.UsuarioPostDTO;
import com.api_controle_acesso.DTOs.UsuarioReturnDTO;
import com.api_controle_acesso.models.Usuario;
import com.api_controle_acesso.repositories.UsuarioRepository;
import com.api_controle_acesso.repositories.ValidacaoException;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(UsuarioPostDTO dadosUsuario) {
        if (usuarioRepository.verificarCpfExistente(dadosUsuario.cpf()).isPresent())
            throw new ValidacaoException("CPF já existente");
        
        var usuario = new Usuario(dadosUsuario);
        return usuarioRepository.save(usuario);
    }

    public Page<UsuarioReturnDTO> visualizarUsuarios( Pageable pageable) {
        var page = usuarioRepository.findAll(pageable).map(UsuarioReturnDTO::new);
        return page;
    }

    public Usuario visualizarUsuario(UUID id) {
        return usuarioRepository.getReferenceById(id);
    }
}
