package com.api.treino.core.domain.usecases;

import org.springframework.security.core.Authentication;

public interface UsuarioAutenticacao {
  public String autenticar(Authentication autenticacao);
}
