package com.api.trainning.application.gateway;

import java.util.List;
import com.api.trainning.core.domain.aluno.Aluno;
import com.api.trainning.core.domain.personal.Exercicio;
import com.api.trainning.core.domain.personal.Treino;

public class CriarTreinoGatewayTest implements CriarTreinoGateway {

  @Override
  public Treino criar(List<Exercicio> exercicios, Aluno aluno) {
    return new Treino(exercicios, aluno);
  }

}
