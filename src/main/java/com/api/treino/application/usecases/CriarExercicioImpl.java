package com.api.treino.application.usecases;

import com.api.treino.application.gateway.ICriarExercicioGateway;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.usecases.CriarExercicio;
import io.micrometer.common.util.StringUtils;

public class CriarExercicioImpl implements CriarExercicio {

  private final ICriarExercicioGateway criarExercicioGateway;

  public CriarExercicioImpl(ICriarExercicioGateway criarExercicioGateway) {
    this.criarExercicioGateway = criarExercicioGateway;
  }

  @Override
  public Exercicio exec(String nome, String instrucao, Personal personal, int repeticao, int serie,
      int carga) throws Exception {

    if (StringUtils.isBlank(nome)) {
      throw new Exception("O exericio precisa de um titulo");
    }

    if (personal == null) {
      throw new Exception("O exercicio precisa de um criador(treinador)");
    }

    Exercicio exercicio =
        this.criarExercicioGateway.criar(nome, instrucao, personal, repeticao, serie, carga);

    if (exercicio == null)
      throw new Exception("Nao foi possivel criar o exercicio");

    return exercicio;
  }

}
