package com.forumHub.forumHub.domain.resposta;

import java.time.LocalDateTime;

public record DadosResposta(Long id, String mensagem, LocalDateTime data_criacao) {
    public DadosResposta(RespostasBD resposta) {
        this(resposta.getId(), resposta.getMensagem(), resposta.getData_criacao());

    }
}