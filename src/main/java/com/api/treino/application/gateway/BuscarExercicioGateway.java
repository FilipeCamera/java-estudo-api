package com.api.treino.application.gateway;

import java.util.List;
import java.util.UUID;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;

public interface BuscarExercicioGateway {
  Exercicio buscar(Personal personal, UUID id);

  List<Exercicio> buscar(Personal personal);
}
