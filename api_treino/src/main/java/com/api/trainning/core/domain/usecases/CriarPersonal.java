package com.api.trainning.core.domain.usecases;

import java.util.List;
import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.Personal.Personal;
import com.api.trainning.core.domain.Personal.Treino;

public interface CriarPersonal {
  Personal exec(UsuarioData usuario, List<Treino> treino);
}
