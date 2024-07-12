package com.forumHub.forumHub.controller;

//import com.forumHub.forumHub.configuracaoSeguranca.TokenJWT;
//import com.forumHub.forumHub.configuracaoSeguranca.TokenService;

import com.forumHub.forumHub.domain.usuario.DadosAutenticacao;
import com.forumHub.forumHub.domain.usuario.UsuarioBD;
import com.forumHub.forumHub.infra.configuracaoSeguranca.TokenJWT;
import com.forumHub.forumHub.infra.configuracaoSeguranca.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
        System.out.println(dadosAutenticacao.login());
        System.out.println(dadosAutenticacao.senha());
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
        var autenticationToken = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((UsuarioBD) autenticationToken.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }
}