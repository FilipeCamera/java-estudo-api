package com.api.treino.application.usecases;

import java.util.List;
import com.api.treino.application.gateway.ICriarTreinoGateway;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Treino;
import com.api.treino.core.domain.usecases.CriarTreino;

public class CriarTreinoImpl implements CriarTreino {

  private final ICriarTreinoGateway criarTreinoGateway;

  public CriarTreinoImpl(ICriarTreinoGateway criarTreinoGateway) {
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
