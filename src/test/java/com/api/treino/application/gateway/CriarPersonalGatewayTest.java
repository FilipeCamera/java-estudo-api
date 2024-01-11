package com.api.treino.application.gateway;

import java.util.List;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.personal.Treino;

public class CriarPersonalGatewayTest implements CriarPersonalGateway {

  @Override
  public Personal criar(UsuarioData usuario, List<Treino> treinos) {
    return new Personal(usuario, treinos);
  }
}
