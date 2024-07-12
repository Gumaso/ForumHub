package com.forumHub.forumHub.domain.topico;

import java.time.LocalDateTime;

public record DadosListaTopicos(
        Long id,
        String titulo,
        String mensagem,
        String nomeCurso,
        String autor,
        LocalDateTime data_criacao) {
    public DadosListaTopicos(TopicoBD topicoBD) {
        this(
                topicoBD.getId(),
                topicoBD.getTitulo(),
                topicoBD.getMensagem(),
                topicoBD.getCurso(),
                topicoBD.getAutor(),
                topicoBD.getData()
        );
    }
}
