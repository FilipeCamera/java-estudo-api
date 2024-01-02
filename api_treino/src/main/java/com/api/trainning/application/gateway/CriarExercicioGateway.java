package com.api.trainning.application.gateway;

import com.api.trainning.core.domain.personal.Exercicio;

public interface CriarExercicioGateway {
  Exercicio criar(String nome, String instrucao, int repeticao, int serie, int carga);
}
