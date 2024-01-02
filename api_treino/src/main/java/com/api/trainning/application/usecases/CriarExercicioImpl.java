package com.api.trainning.application.usecases;

import com.api.trainning.application.gateway.CriarExercicioGateway;
import com.api.trainning.core.domain.personal.Exercicio;
import com.api.trainning.core.domain.usecases.CriarExercicio;

public class CriarExercicioImpl implements CriarExercicio {

  private final CriarExercicioGateway criarExercicioGateway;

  public CriarExercicioImpl(CriarExercicioGateway criarExercicioGateway) {
    this.criarExercicioGateway = criarExercicioGateway;
  }

  @Override
  public Exercicio exec(String nome, String instrucao, int repeticao, int serie, int carga)
      throws Exception {
    Exercicio exercicio =
        this.criarExercicioGateway.criar(nome, instrucao, repeticao, serie, carga);

    if (exercicio == null)
      throw new Exception("Nao foi possivel criar o exercicio");

    return exercicio;
  }

}
