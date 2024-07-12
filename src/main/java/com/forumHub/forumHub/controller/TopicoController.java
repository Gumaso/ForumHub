package com.forumHub.forumHub.controller;

import com.forumHub.forumHub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;


    @GetMapping
    public Page<DadosListaTopicos> listandoTopicos(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListaTopicos::new);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity registrandoTopico(@RequestBody DadosTopico dados) {
        var dataHoraAgora = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        System.out.println(dataHoraAgora);
        var dadosTopico = new DadosTopico(dados.id(), dados.titulo(), dados.mensagem(), dados.nomeCurso(), dados.autor(), dataHoraAgora);
        var topicoBancoDados = new TopicoBD(dadosTopico);
        repository.save(topicoBancoDados);
        System.out.println(dadosTopico);
        return ResponseEntity.ok(topicoBancoDados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhadosTopico> detalharTopico(@PathVariable Long id) {
        Optional<TopicoBD> topicoOptional = repository.findById(id);
        if (topicoOptional.isPresent()) {
            DadosDetalhadosTopico dto = new DadosDetalhadosTopico(topicoOptional.get());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTopico(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        repository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarDadosMedico(@PathVariable Long id, @RequestBody @Valid DadosAtualizandoTopico atualizandoTopico) {
        var topico = repository.getReferenceById(id);
        topico.atualizarInfomarcoes(atualizandoTopico);
        return ResponseEntity.ok(new DadosDetalhadosTopico(topico));
    }

}
