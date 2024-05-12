package com.api.treino.application.usecases;

import java.util.List;
import java.util.UUID;
import com.api.treino.application.gateway.BuscarExercicioGateway;
import com.api.treino.core.domain.exceptions.NotFoundException;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.usecases.BuscarExercicio;

public class BuscarExercicioImpl implements BuscarExercicio {

  private BuscarExercicioGateway buscarExercicioGateway;

  public BuscarExercicioImpl(BuscarExercicioGateway buscarExercicioGateway) {
    this.buscarExercicioGateway = buscarExercicioGateway;

  }

  @Override
  public Exercicio buscar(Personal personal, UUID id) throws Exception {
    Exercicio exercicio = this.buscarExercicioGateway.buscar(personal, id);

    if (exercicio == null) {
      throw new NotFoundException("Nao foi encontrado o exercicio");
    }
    return exercicio;
  }

  @Override
  public List<Exercicio> buscar(Personal personal) throws Exception {
    List<Exercicio> exercicios = this.buscarExercicioGateway.buscar(personal);

    if (exercicios.size() == 0) {
      throw new NotFoundException("Nenhum exercicio encontrado");
    }
    return exercicios;
  }

}
