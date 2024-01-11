package com.api.treino.application.usecases;

import com.api.treino.application.gateway.CriarExercicioGateway;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.usecases.CriarExercicio;
import io.micrometer.common.util.StringUtils;

public class CriarExercicioImpl implements CriarExercicio {

  private final CriarExercicioGateway criarExercicioGateway;

  public CriarExercicioImpl(CriarExercicioGateway criarExercicioGateway) {
    this.criarExercicioGateway = criarExercicioGateway;
  }

  @Override
  public Exercicio exec(String nome, String instrucao, int repeticao, int serie, int carga)
      throws Exception {

    Exercicio exercicio = null;

    if (!StringUtils.isBlank(nome)) {
      exercicio = this.criarExercicioGateway.criar(nome, instrucao, repeticao, serie, carga);
    }

    if (exercicio == null)
      throw new Exception("Nao foi possivel criar o exercicio");

    return exercicio;
  }

}
