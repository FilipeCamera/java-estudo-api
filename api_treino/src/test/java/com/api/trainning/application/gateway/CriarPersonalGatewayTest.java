package com.api.trainning.application.gateway;

import java.util.List;
import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.personal.Personal;
import com.api.trainning.core.domain.personal.Treino;

public class CriarPersonalGatewayTest implements CriarPersonalGateway {

  @Override
  public Personal criar(UsuarioData usuario, List<Treino> treinos) {

    Personal personal = new Personal(usuario, treinos);

    return personal;
  }

}
