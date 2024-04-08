package com.api_controle_acesso.DTOs.TransacaoDTO;
import java.time.LocalDateTime;
import java.util.UUID;

import com.api_controle_acesso.models.Transacao;
import com.api_controle_acesso.models.Usuario;
import com.api_controle_acesso.models.enums.DiaSemana;
import com.api_controle_acesso.models.enums.TipoTransacao;

public record TransacaoReturnDTO(UUID id, Usuario usuario, TipoTransacao tipoTransacao, LocalDateTime hora, DiaSemana diaSemana) {

    public TransacaoReturnDTO(Transacao transacao) {
        this(transacao.getId(), transacao.getUsuario(), transacao.getTipoTransacao(), transacao.getHora(), transacao.getDiaSemana());
    }
    
}
