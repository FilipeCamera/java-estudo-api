package com.api.trainning.core.domain.usecases;

import com.api.trainning.core.domain.personal.Exercicio;

public interface CriarExercicio {
  Exercicio exec(String nome, String instrucao, int repeticao, int serie, int carga)
      throws Exception;
}
