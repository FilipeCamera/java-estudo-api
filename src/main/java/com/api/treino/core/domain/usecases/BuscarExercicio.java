package com.api.treino.core.domain.usecases;

import java.util.List;
import java.util.UUID;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;

public interface BuscarExercicio {
  Exercicio buscar(Personal personal, UUID id) throws Exception;

  List<Exercicio> buscar(Personal personal) throws Exception;
}
