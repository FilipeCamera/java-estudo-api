package com.api.treino.core.domain.usecases;

import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;

public interface CriarExercicio {
  Exercicio exec(String nome, String instrucao, Personal personal, int repeticao, int serie,
      int carga) throws Exception;
}
