package com.api.trainning.application.gateway;

import java.util.List;
import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.personal.Personal;
import com.api.trainning.core.domain.personal.Treino;

public interface CriarPersonalGateway {
  Personal criar(UsuarioData usuario, List<Treino> treinos);
}
