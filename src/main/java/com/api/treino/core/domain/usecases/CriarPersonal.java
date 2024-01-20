package com.api.treino.core.domain.usecases;

import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;

public interface CriarPersonal {
  Personal exec(UsuarioData usuario) throws Exception;
}
