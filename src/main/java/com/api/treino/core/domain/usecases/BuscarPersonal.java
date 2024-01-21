package com.api.treino.core.domain.usecases;

import java.util.List;
import java.util.UUID;
import com.api.treino.core.domain.personal.Personal;

public interface BuscarPersonal {
  Personal buscar(UUID id) throws Exception;

  List<Personal> buscar() throws Exception;
}
