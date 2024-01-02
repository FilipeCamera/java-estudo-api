package com.api.trainning.application.usecases;

import java.util.List;
import com.api.trainning.application.gateway.CriarTreinoGateway;
import com.api.trainning.core.domain.aluno.Aluno;
import com.api.trainning.core.domain.personal.Exercicio;
import com.api.trainning.core.domain.personal.Treino;
import com.api.trainning.core.domain.usecases.CriarTreino;

public class CriarTreinoImpl implements CriarTreino {

  private final CriarTreinoGateway criarTreinoGateway;

  public CriarTreinoImpl(CriarTreinoGateway criarTreinoGateway) {
    this.criarTreinoGateway = criarTreinoGateway;
  }

  @Override
  public Treino exec(List<Exercicio> exercicios, Aluno aluno) throws Exception {
    Treino treino = this.criarTreinoGateway.criar(exercicios, aluno);

    if (treino == null)
      throw new Exception("Nao foi possivel criar treino");

    return treino;
  }

}
