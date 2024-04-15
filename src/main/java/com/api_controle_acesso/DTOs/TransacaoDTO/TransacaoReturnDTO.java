package com.api_controle_acesso.DTOs.TransacaoDTO;
import java.time.LocalDateTime;
import java.util.UUID;
import com.api_controle_acesso.DTOs.UsuarioDTO.UsuarioReturnDTO;
import com.api_controle_acesso.models.Transacao;
import com.api_controle_acesso.models.enums.DiaSemana;
import com.api_controle_acesso.models.enums.TipoTransacao;

public record TransacaoReturnDTO(UUID id, UsuarioReturnDTO usuario, TipoTransacao tipoTransacao, LocalDateTime hora, DiaSemana diaSemana) {

    public TransacaoReturnDTO(Transacao transacao) {
        this(transacao.getId(), new UsuarioReturnDTO(transacao.getUsuario()), transacao.getTipoTransacao(), transacao.getHora(), transacao.getDiaSemana());
    }
}
