package com.api.treino.application.usecases;

import com.api.treino.application.gateway.CriarPersonalGateway;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.usecases.CriarPersonal;

public class CriarPersonalImpl implements CriarPersonal {

  private final CriarPersonalGateway criarPersonalGateway;

  public CriarPersonalImpl(CriarPersonalGateway criarPersonalGateway) {
    this.criarPersonalGateway = criarPersonalGateway;
  }

  @Override
  public Personal exec(UsuarioData usuario) throws Exception {
    Personal personal = this.criarPersonalGateway.criar(usuario);

    if (personal == null || personal.usuario() == null)
      throw new Exception("Nao foi possivel criar o usuario");
    // TODO Auto-generated method stub
    return personal;
  }

}
