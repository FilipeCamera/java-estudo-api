package com.api.treino.infrastructure.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.treino.core.domain.usecases.UsuarioAutenticacao;

@RestController
@RequestMapping("/api/v1/auth")
public class UsuarioAutenticacaoController {

  private final UsuarioAutenticacao usuarioAutenticacao;

  public UsuarioAutenticacaoController(UsuarioAutenticacao usuarioAutenticacao) {
    this.usuarioAutenticacao = usuarioAutenticacao;
  }

  @PostMapping("login")
  public String login(Authentication autenticacao) {
    return this.usuarioAutenticacao.autenticar(autenticacao);
  }

}
