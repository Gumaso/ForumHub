package com.forumHub.forumHub.domain.topico;

import com.forumHub.forumHub.domain.resposta.RespostasBD;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "topicos")
@EqualsAndHashCode(of = "id")
public class TopicoBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensagem;
    private String curso;
    private String autor;
    private LocalDateTime data_criacao;
    @Enumerated(value = EnumType.STRING)
    private Status estado_do_topico;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RespostasBD> respostas = new ArrayList<>();


    public TopicoBD(DadosTopico dadosTopico) {
        this.titulo = dadosTopico.titulo();
        this.mensagem = dadosTopico.mensagem();
        this.curso = dadosTopico.nomeCurso();
        this.autor = dadosTopico.autor();
        this.data_criacao = dadosTopico.data_criacao();
    }

    public TopicoBD() {
    }

    public TopicoBD(String titulo, String mensagem, String curso, String autor, LocalDateTime data_criacao, Status estado_do_topico) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.curso = curso;
        this.autor = autor;
        this.data_criacao = data_criacao;
        this.estado_do_topico = estado_do_topico;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Status getEstado_do_topico() {
        return estado_do_topico;
    }

    public void setEstado_do_topico(Status estado_do_topico) {
        this.estado_do_topico = estado_do_topico;
    }

    public LocalDateTime getData() {
        return data_criacao;
    }

    public void setData(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<RespostasBD> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostasBD> respostas) {
        this.respostas = respostas;
    }

    public void atualizarInfomarcoes(DadosAtualizandoTopico atualizandoTopico) {
        if (atualizandoTopico.titulo() != null) {
            this.titulo = atualizandoTopico.titulo();
        }
        if (atualizandoTopico.mensagem() != null) {
            this.mensagem = atualizandoTopico.mensagem();
        }

    }

    public void addResposta(RespostasBD resposta) {
        respostas.add(resposta);
        resposta.setTopico(this);
    }

    public void removeResposta(RespostasBD resposta) {
        respostas.remove(resposta);
        resposta.setTopico(null);
    }
}
