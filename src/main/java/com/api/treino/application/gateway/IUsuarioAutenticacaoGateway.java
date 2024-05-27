package com.api.treino.application.gateway;

import org.springframework.security.core.Authentication;

public interface IUsuarioAutenticacaoGateway {
  public String gerarToken(Authentication autenticacao);
}
