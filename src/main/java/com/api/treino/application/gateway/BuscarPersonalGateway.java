package com.api.treino.application.gateway;

import java.util.List;
import java.util.UUID;
import com.api.treino.core.domain.personal.Personal;

public interface BuscarPersonalGateway {
  Personal buscar(UUID id);

  List<Personal> buscar();
}
