package com.api.treino.application.gateway;

import com.api.treino.core.domain.personal.Exercicio;

public interface CriarExercicioGateway {
  Exercicio criar(String nome, String instrucao, int repeticao, int serie, int carga);
}
