package com.api.treino.infrastructure.services;

import java.time.Instant;
import org.springframework.security.core.Authentication;
import com.api.treino.application.gateway.UsuarioAutenticacaoGateway;

public class UsuarioAutenticacaoGatewayImpl implements UsuarioAutenticacaoGateway {

  @Override
  public String gerarToken(Authentication autenticacao) {
    Instant agora = Instant.now();
    Long expiraEm = 3600L;

    return "";
  }

}
