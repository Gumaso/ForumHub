package com.forumHub.forumHub.domain.topico;

import com.forumHub.forumHub.domain.resposta.DadosResposta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalhadosTopico(
        Long id,
        String titulo,
        String mensagem,
        String nomeCurso,
        String autor,
        LocalDateTime data_criacao,
        Status status,
        List<DadosResposta> respostas

) {
    public DadosDetalhadosTopico(TopicoBD topicoBD) {
        this(
                topicoBD.getId(),
                topicoBD.getTitulo(),
                topicoBD.getMensagem(),
                topicoBD.getCurso(),
                topicoBD.getAutor(),
                topicoBD.getData(),
                topicoBD.getEstado_do_topico(),
                topicoBD.getRespostas().stream().map(DadosResposta::new).collect(Collectors.toList())

        );
    }
}

