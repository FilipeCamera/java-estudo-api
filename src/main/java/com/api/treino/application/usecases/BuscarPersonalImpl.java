package com.api.treino.application.usecases;

import java.util.List;
import java.util.UUID;
import com.api.treino.application.gateway.BuscarPersonalGateway;
import com.api.treino.core.domain.exceptions.NotFoundException;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.usecases.BuscarPersonal;

public class BuscarPersonalImpl implements BuscarPersonal {

  private BuscarPersonalGateway buscarPersonalGateway;

  public BuscarPersonalImpl(BuscarPersonalGateway buscarPersonalGateway) {
    this.buscarPersonalGateway = buscarPersonalGateway;
  }

  @Override
  public Personal buscar(UUID id) throws Exception {

    Personal personal = this.buscarPersonalGateway.buscar(id);

    if (personal == null) {
      throw new NotFoundException("Personal nao encontrado");
    }

    return personal;
  }

  @Override
  public List<Personal> buscar() throws Exception {
    // TODO Auto-generated method stub
    List<Personal> personals = this.buscarPersonalGateway.buscar();

    if (personals.isEmpty()) {
      throw new NotFoundException("Personals nao encontrado");
    }
    return personals;
  }

}
