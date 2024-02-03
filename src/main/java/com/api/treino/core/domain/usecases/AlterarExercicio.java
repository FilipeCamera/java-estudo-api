package com.api.treino.core.domain.usecases;

import com.api.treino.core.domain.personal.Exercicio;

public interface AlterarExercicio {
  Exercicio alterar(Exercicio exercicio, Exercicio exercicioNovo) throws Exception;
}
