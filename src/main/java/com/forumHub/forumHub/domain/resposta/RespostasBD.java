package com.forumHub.forumHub.domain.resposta;

import com.forumHub.forumHub.domain.topico.TopicoBD;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
public class RespostasBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private String autor;
    private LocalDateTime data_criacao;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private TopicoBD topico;

    public RespostasBD() {
    }

    public RespostasBD(String mensagem, String autor, LocalDateTime data_criacao, TopicoBD topico) {
        this.mensagem = mensagem;
        this.autor = autor;
        this.data_criacao = data_criacao;
        this.topico = topico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }

    public TopicoBD getTopico() {
        return topico;
    }

    public void setTopico(TopicoBD topico) {
        this.topico = topico;
    }
}

