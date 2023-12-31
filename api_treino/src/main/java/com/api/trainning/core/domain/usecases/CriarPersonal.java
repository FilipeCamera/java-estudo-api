package com.api.trainning.core.domain.usecases;

import java.util.List;
import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.personal.Personal;
import com.api.trainning.core.domain.personal.Treino;

public interface CriarPersonal {
  Personal exec(UsuarioData usuario, List<Treino> treinos) throws Exception;
}
