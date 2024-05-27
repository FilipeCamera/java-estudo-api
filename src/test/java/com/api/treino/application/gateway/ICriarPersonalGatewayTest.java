package com.api.treino.application.gateway;

import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;

public class ICriarPersonalGatewayTest implements ICriarPersonalGateway {

  @Override
  public Personal criar(UsuarioData usuario) {
    return new Personal(usuario);
  }
}
