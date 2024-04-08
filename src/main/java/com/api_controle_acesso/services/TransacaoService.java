package com.api_controle_acesso.services;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.api_controle_acesso.DTOs.TransacaoDTO.TransacaoPostDTO;
import com.api_controle_acesso.DTOs.TransacaoDTO.TransacaoReturnDTO;
import com.api_controle_acesso.models.Transacao;
import com.api_controle_acesso.repositories.TransacaoRepository;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao criarTransacao(TransacaoPostDTO transacaoPostDTO) {

        var transacao = new Transacao(transacaoPostDTO);

        return transacaoRepository.save(transacao);
    }

    public Page<TransacaoReturnDTO> visualizarTransacoes(Pageable pageable) {
        var page = transacaoRepository.findAll(pageable).map(TransacaoReturnDTO::new);
        return page;
    }

    public Transacao visualizarTransacao(UUID id) {
        return transacaoRepository.getReferenceById(id);
    }
    
}
