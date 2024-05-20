package com.api.treino.application.usecases;

import org.springframework.security.core.Authentication;
import com.api.treino.application.gateway.UsuarioAutenticacaoGateway;
import com.api.treino.core.domain.usecases.UsuarioAutenticacao;

public class UsuarioAutenticacaoImpl implements UsuarioAutenticacao {
  private final UsuarioAutenticacaoGateway usuarioAutenticacaoGateway;

  public UsuarioAutenticacaoImpl(UsuarioAutenticacaoGateway usuarioAutenticacaoGateway) {
    this.usuarioAutenticacaoGateway = usuarioAutenticacaoGateway;
  }

  @Override
  public String autenticar(Authentication autenticacao) {
    return this.usuarioAutenticacaoGateway.gerarToken(autenticacao);
  }

}
