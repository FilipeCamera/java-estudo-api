package com.api.treino.application.gateway;

import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;

public interface ICriarExercicioGateway {
  Exercicio criar(String nome, String instrucao, Personal personal, int repeticao, int serie,
      int carga);
}
