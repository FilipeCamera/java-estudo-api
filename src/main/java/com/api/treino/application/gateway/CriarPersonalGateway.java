package com.api.treino.application.gateway;

import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;

public interface CriarPersonalGateway {
  Personal criar(UsuarioData usuario);
}
