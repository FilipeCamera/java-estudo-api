package com.api.treino.application.gateway;

import com.api.treino.core.domain.personal.Exercicio;

public class CriarExercicioGatewayTest implements CriarExercicioGateway {

  @Override
  public Exercicio criar(String nome, String instrucao, int repeticao, int serie, int carga) {
    return new Exercicio(nome, instrucao, repeticao, serie, carga);
  }

}
