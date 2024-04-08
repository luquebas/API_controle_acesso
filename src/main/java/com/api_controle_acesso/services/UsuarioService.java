package com.api_controle_acesso.services;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.api_controle_acesso.DTOs.UsuarioDTO.UsuarioPostDTO;
import com.api_controle_acesso.DTOs.UsuarioDTO.UsuarioReturnDTO;
import com.api_controle_acesso.exceptions.ValidacaoException;
import com.api_controle_acesso.models.Usuario;
import com.api_controle_acesso.models.enums.Role;
import com.api_controle_acesso.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    public Usuario criarUsuario(UsuarioPostDTO dadosUsuario) {
        if (usuarioRepository.verificarCpfExistente(dadosUsuario.cpf()).isPresent())
            throw new ValidacaoException("CPF já existente");
        
        var usuario = new Usuario(dadosUsuario);
        usuario.setRole(Role.ROLE_USER);
        usuario.setSenha(passwordEncoder.encode((dadosUsuario.senha())));

        return usuarioRepository.save(usuario);
    }

    public Page<UsuarioReturnDTO> visualizarUsuarios(Pageable pageable) {
        var page = usuarioRepository.findAll(pageable).map(UsuarioReturnDTO::new);
        return page;
    }

    public Usuario visualizarUsuario(UUID id) {
        return usuarioRepository.getReferenceById(id);
    }

    public void deleteUsuario(UUID id) {
        var usuario = usuarioRepository.getReferenceById(id);
        try {
            usuarioRepository.delete(usuario);      
        } catch (Exception e) {
            throw new RuntimeException("Não foi Possível deletar esse Usuário!");
        }
    }

    public Usuario findUsuarioByMatricula(String matricula) {
        var usuario = usuarioRepository.findByMatricula(matricula);
        return usuario;
    }
}
