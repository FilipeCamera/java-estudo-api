package com.api.treino.application.usecases;

import org.springframework.security.core.Authentication;
import com.api.treino.application.gateway.IUsuarioAutenticacaoGateway;
import com.api.treino.core.domain.usecases.UsuarioAutenticacao;

public class UsuarioAutenticacaoImpl implements UsuarioAutenticacao {
  private final IUsuarioAutenticacaoGateway usuarioAutenticacaoGateway;

  public UsuarioAutenticacaoImpl(IUsuarioAutenticacaoGateway usuarioAutenticacaoGateway) {
    this.usuarioAutenticacaoGateway = usuarioAutenticacaoGateway;
  }

  @Override
  public String autenticar(Authentication autenticacao) {
    return this.usuarioAutenticacaoGateway.gerarToken(autenticacao);
  }

}
